package com.tencent.mm.plugin.accountsync.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.modelsimple.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class ContactsSyncService extends Service implements e {
    private static Account hMw;
    private a ikZ = null;
    private Looper ila;

    private class a extends AbstractThreadedSyncAdapter {
        final /* synthetic */ ContactsSyncService ilb;
        private Context mContext;

        public a(ContactsSyncService contactsSyncService, Context context) {
            this.ilb = contactsSyncService;
            super(context, true);
            this.mContext = context;
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (ar.Hj()) {
                try {
                    Looper.prepare();
                    this.ilb.ila = Looper.myLooper();
                    ContactsSyncService.a(this.ilb, account);
                    Looper.loop();
                    return;
                } catch (Exception e) {
                    this.ilb.Xq();
                    x.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e.getMessage());
                    return;
                }
            }
            x.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        }
    }

    static /* synthetic */ void a(ContactsSyncService contactsSyncService, Account account) {
        hMw = account;
        if (!ar.Hi() || ar.Cs()) {
            contactsSyncService.Xq();
            x.e("MicroMsg.ContactsSyncService", "performSync error: no user login");
        } else if (m.NL()) {
            x.i("MicroMsg.ContactsSyncService", "performSync start");
            if (!com.tencent.mm.modelfriend.a.a(new 1(contactsSyncService))) {
                contactsSyncService.Xq();
                x.i("MicroMsg.ContactsSyncService", "performSync result false");
            }
        } else {
            x.e("MicroMsg.ContactsSyncService", "this user has not agreed to upload address book");
            contactsSyncService.Xq();
        }
    }

    public ContactsSyncService() {
        x.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = null;
        if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
            if (this.ikZ == null) {
                this.ikZ = new a(this, getApplicationContext());
            }
            iBinder = this.ikZ.getSyncAdapterBinder();
        } else {
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        x.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", new Object[]{iBinder});
        return iBinder;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == d.CTRL_INDEX) {
            ar.CG().b(d.CTRL_INDEX, this);
            x.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i + ", errCode = " + i2);
            ar.Hg();
            long longValue = ((Long) c.CU().get(327728, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            x.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i2 == 0 || currentTimeMillis - longValue >= 86400000) {
                ar.Hg();
                c.CU().set(327728, Long.valueOf(currentTimeMillis));
                ar.CG().a(32, this);
                aa aaVar = (aa) kVar;
                ar.CG().a(new v(aaVar.hwE, aaVar.hwF), 0);
            } else {
                Xq();
                x.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                return;
            }
        }
        if (kVar.getType() == 32) {
            ar.CG().b(32, this);
            x.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i + ", errCode = " + i2);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.b(new b(this, hMw), "MMAccountManager_updateLocalContacts").start();
            }
            Xq();
        }
    }

    private void Xq() {
        if (this.ila != null) {
            this.ila.quit();
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.ContactsSyncService", "contacts sync service destory");
        super.onDestroy();
    }
}

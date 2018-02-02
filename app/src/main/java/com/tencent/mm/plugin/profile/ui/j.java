package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ay.n;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class j implements a, b {
    private static boolean isDeleteCancel = false;
    private Context context;
    private f ilB;
    private x jLe;

    static class AnonymousClass4 extends af {
        final /* synthetic */ boolean kCv;
        final /* synthetic */ o kCw = null;
        final /* synthetic */ Context val$context;

        AnonymousClass4(boolean z, Context context, o oVar) {
            this.kCv = z;
            this.val$context = context;
        }

        public final void handleMessage(Message message) {
            int i;
            if (this.kCv) {
                j.hj(true);
            }
            int Gd = q.Gd();
            if (this.kCv) {
                i = Gd & -17;
            } else {
                i = Gd | 16;
            }
            ar.Hg();
            c.CU().set(34, Integer.valueOf(i));
            ar.Hg();
            c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kCv) {
                j.dn(this.val$context);
            }
            if (this.kCw != null) {
                this.kCw.a(null, null);
            }
        }
    }

    static /* synthetic */ void dn(Context context) {
        isDeleteCancel = false;
        context.getString(R.l.dGO);
        ba.a("medianote", new 7(h.a(context, context.getString(R.l.dHc), true, new 6())));
        ar.Hg();
        c.Fd().WX("medianote");
    }

    public j(Context context) {
        this.context = context;
    }

    public final boolean vQ(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = " + str);
        if (bh.ou(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            com.tencent.mm.plugin.profile.a.ifs.e(intent, this.context);
            com.tencent.mm.plugin.profile.a.ift.um();
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (q.Gz()) {
                hj(((CheckBoxPreference) this.ilB.YN(str)).isChecked());
            } else {
                h.a(this.context, R.l.dVC, R.l.dVB, new 1(this), null);
                arR();
            }
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUG), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new 2(this), null);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMD), "", this.context.getString(R.l.dEo), this.context.getString(R.l.dEn), new OnClickListener(this) {
                final /* synthetic */ j pjn;

                {
                    this.pjn = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.g(this.pjn.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gU(xVar.field_username));
        ar.Hg();
        c.CU().a(this);
        this.jLe = xVar;
        this.ilB = fVar;
        fVar.addPreferencesFromResource(R.o.fbv);
        arR();
        return true;
    }

    private void arR() {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = true;
        boolean z4 = (q.Gd() & 16) == 0;
        int FW = q.FW();
        if (q.Gz()) {
            z = (FW & 16384) != 0;
        } else {
            if ((FW & 16384) != 0) {
                FW &= -16385;
                ar.Hg();
                c.CU().set(7, Integer.valueOf(FW));
            }
            z = false;
        }
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ilB.YN("contact_info_header_helper");
        helperHeaderPreference.ae(this.jLe.field_username, this.jLe.AQ(), this.context.getString(R.l.dVD));
        if (z4) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nx(i);
        this.ilB.bk("contact_info_medianote_install", z4);
        f fVar = this.ilB;
        String str = "contact_info_medianote_view";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bk(str, z2);
        if (!z4 || q.Gz()) {
            z2 = z4;
        } else {
            if (bh.getInt(g.zY().getValue("BindQQSwitch"), 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        fVar = this.ilB;
        str = "contact_info_medianote_sync_to_qqmail";
        if (z2) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bk(str, z2);
        fVar = this.ilB;
        str = "contact_info_medianote_clear_data";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bk(str, z2);
        f fVar2 = this.ilB;
        String str2 = "contact_info_medianote_uninstall";
        if (z4) {
            z3 = false;
        }
        fVar2.bk(str2, z3);
        ((CheckBoxPreference) this.ilB.YN("contact_info_medianote_sync_to_qqmail")).tSw = z;
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMA) : context.getString(R.l.eMH);
        context.getString(R.l.dGO);
        final r a = h.a(context, string, true, null);
        final af anonymousClass4 = new AnonymousClass4(z, context, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass4.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean arS() {
        ar.Hg();
        c.CU().b(this);
        com.tencent.mm.plugin.profile.a.ift.um();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (o == 40 || o == 34 || o == 7) {
            arR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    static void hj(boolean z) {
        int FW = q.FW();
        if (z) {
            FW |= 16384;
        } else {
            FW &= -16385;
        }
        ar.Hg();
        c.CU().set(7, Integer.valueOf(FW));
        FW = z ? 1 : 2;
        ar.Hg();
        c.EX().b(new com.tencent.mm.ay.g(13, FW));
    }
}

package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.on;
import com.tencent.mm.m.a;
import com.tencent.mm.plugin.webwx.a.g.3;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;

class g$3$1 implements e {
    final /* synthetic */ d tOu;
    final /* synthetic */ on tOv;
    final /* synthetic */ 3 tOw;

    g$3$1(3 3, d dVar, on onVar) {
        this.tOw = 3;
        this.tOu = dVar;
        this.tOv = onVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        CharSequence charSequence;
        Intent intent;
        Object obj;
        ar.CG().b(971, this);
        tq tqVar = (tq) this.tOu.hFi.hmh.hmo;
        x.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            if (tqVar.wbC != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("intent.key.login.url", this.tOv.fGv.fGw);
                intent2.putExtra("intent.key.type", 0);
                intent2.putExtra("intent.key.icon.type", tqVar.wbC.wby);
                intent2.putExtra("intent.key.ok.string", tqVar.wbC.wbM);
                intent2.putExtra("intent.key.cancel.string", tqVar.wbC.wbN);
                intent2.putExtra("intent.key.title.string", tqVar.wbC.wbz);
                intent2.putExtra("intent.key.content.string", tqVar.wbC.wbR);
                intent2.putExtra("intent.key.login.client.version", tqVar.wbG);
                intent2.putExtra("intent.key.function.control", tqVar.wbH);
                String str2 = tqVar.wbC.wbz;
                StringBuilder stringBuilder = new StringBuilder();
                Cursor cursor = null;
                try {
                    ar.Hg();
                    cursor = c.Fd().a(s.hfk, null, a.gJf, true);
                    if (cursor != null) {
                        int count;
                        if (cursor.getCount() < tqVar.wbC.wbO) {
                            count = cursor.getCount();
                        } else {
                            count = tqVar.wbC.wbO;
                        }
                        int columnIndex = cursor.getColumnIndex("username");
                        for (int i3 = 0; i3 < count; i3++) {
                            if (cursor.moveToPosition(i3)) {
                                stringBuilder.append(cursor.getString(columnIndex));
                                if (i3 < count - 1) {
                                    stringBuilder.append(",");
                                }
                            }
                        }
                    }
                    intent2.putExtra("intent.key.ok.session.list", stringBuilder.toString());
                    if (cursor != null) {
                        cursor.close();
                        charSequence = str2;
                        intent = intent2;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SubCoreWebWX", e, "[oneliang]get session list error.", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                        obj = str2;
                        intent = intent2;
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                obj = str2;
                intent = intent2;
            }
            charSequence = null;
            intent = null;
        } else if (i2 == -1) {
            if (tqVar.wbD != null) {
                intent = new Intent();
                intent.putExtra("intent.key.login.url", this.tOv.fGv.fGw);
                intent.putExtra("intent.key.type", -1);
                intent.putExtra("intent.key.title.string", tqVar.wbD.wbA);
                intent.putExtra("intent.key.icon.type", tqVar.wbD.wby);
                intent.putExtra("intent.key.ok.string", tqVar.wbD.wbB);
                intent.putExtra("intent.key.content.string", tqVar.wbD.wbz);
                charSequence = tqVar.wbD.wbz;
            }
            charSequence = null;
            intent = null;
        } else {
            if (i2 == -2 && tqVar.wbE != null) {
                intent = new Intent();
                intent.putExtra("intent.key.login.url", this.tOv.fGv.fGw);
                intent.putExtra("intent.key.type", -2);
                intent.putExtra("intent.key.title.string", tqVar.wbE.wbA);
                intent.putExtra("intent.key.icon.type", tqVar.wbE.wby);
                intent.putExtra("intent.key.ok.string", tqVar.wbE.wbB);
                intent.putExtra("intent.key.content.string", tqVar.wbE.wbz);
                charSequence = tqVar.wbE.wbz;
            }
            charSequence = null;
            intent = null;
        }
        if (intent != null) {
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setClass(ac.getContext(), ExtDeviceWXLoginUI.class);
            ac.getContext().startActivity(intent);
            Intent intent3 = new Intent(intent);
            intent3.setFlags(67108864);
            if (this.tOv.fGv.type == 1) {
                Notification notification = new Builder(ac.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(ac.getContext().getString(R.l.app_name)).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(ac.getContext(), 0, intent3, 134217728)).getNotification();
                notification.icon = com.tencent.mm.bl.a.bXV();
                notification.flags |= 16;
                notification.sound = RingtoneManager.getDefaultUri(2);
                ar.getNotification().notify(38, notification);
            }
        }
    }
}

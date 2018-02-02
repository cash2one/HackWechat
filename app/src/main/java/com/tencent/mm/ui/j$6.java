package com.tencent.mm.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.o.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.j.3;
import com.tencent.mm.ui.j.5;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$6 implements Runnable {
    final /* synthetic */ j xFL;

    j$6(j jVar) {
        this.xFL = jVar;
    }

    public final void run() {
        int i;
        boolean z;
        boolean booleanValue;
        String str;
        SharedPreferences cft = ac.cft();
        long j = cft.getLong("show_sdcard_full_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = currentTimeMillis - j > 10800000 || j > currentTimeMillis;
        j jVar = this.xFL;
        int AV = a.AV();
        boolean zf = f.zf();
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space _dataRet[%d] checkSdIsFull[%b] needShowAlert[%b] testCode[%d] ", new Object[]{Integer.valueOf(jVar.hashCode()), Integer.valueOf(AV), Boolean.valueOf(zf), Boolean.valueOf(z2), Integer.valueOf(jVar.fpk)});
        if (jVar.fpk == 1) {
            i = 1;
            z = true;
            jVar.fpk = 4;
        } else {
            boolean z3;
            int i2;
            if (jVar.fpk == 2) {
                z = true;
                z3 = zf;
                i2 = 2;
                z2 = z3;
            } else if (jVar.fpk == 3) {
                i2 = 0;
                z2 = true;
                z = true;
            } else if (jVar.fpk == 4) {
                jVar.fpk = 0;
                z2 = false;
                if (z2) {
                    cft.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
                }
                if (!z2) {
                    ar.Hg();
                    if (((Boolean) c.CU().get(w.a.xoS, Boolean.valueOf(false))).booleanValue()) {
                        ar.Hg();
                        if (t.ov((String) c.CU().get(6, ""))) {
                            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", new Object[]{(String) c.CU().get(6, "")});
                        } else {
                            ar.Hg();
                            booleanValue = ((Boolean) c.CU().get(w.a.xoT, Boolean.valueOf(false))).booleanValue();
                            ar.Hg();
                            str = (String) c.CU().get(w.a.xoU, this.xFL.getString(R.l.dLh));
                            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[]{Boolean.valueOf(z), r0, Boolean.valueOf(booleanValue), str});
                            if (booleanValue) {
                                h.a(this.xFL.xFE, str, this.xFL.getString(R.l.dGO), this.xFL.getString(R.l.dFU), this.xFL.getString(R.l.dEn), new 2(this, str), new 3(this));
                            } else {
                                h.a(this.xFL.xFE, str, this.xFL.getString(R.l.dGO), this.xFL.getString(R.l.dFU), false, new 1(this, str));
                            }
                        }
                        ar.Hg();
                        c.CU().a(w.a.xoS, Boolean.valueOf(false));
                        ar.Hg();
                        c.CU().a(w.a.xoU, "");
                        ar.Hg();
                        c.CU().lH(true);
                    }
                }
            } else {
                z3 = zf;
                i2 = AV;
                z = z2;
                z2 = z3;
            }
            jVar.fpk = 0;
            z3 = z2;
            i = i2;
            zf = z3;
        }
        i.a aVar;
        if (i == 1) {
            if (z) {
                z2 = true;
                aVar = new i.a(jVar.xFE);
                aVar.Ez(R.l.dTw);
                aVar.YG(jVar.xFE.getString(R.l.dTv));
                aVar.mi(false);
                aVar.EC(R.l.dTs).a(new 3(jVar));
                aVar.akx().show();
                x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d show no space notification isShowLackSpaceNotification[%b]", new Object[]{Integer.valueOf(jVar.hashCode()), Boolean.valueOf(jVar.xFI)});
                if (!jVar.xFI) {
                    ar.getNotification().cancel(45);
                    jVar.xFI = true;
                    Notification build = new Builder(ac.getContext()).setTicker(jVar.getString(R.l.dTw)).setContentTitle(jVar.getString(R.l.dTw)).setContentText(jVar.getString(R.l.dTv)).setAutoCancel(false).setContentIntent(PendingIntent.getActivity(ac.getContext(), 45, new Intent(ac.getContext(), LauncherUI.class), 134217728)).setOngoing(true).build();
                    build.icon = com.tencent.mm.bl.a.bXV();
                    build.flags |= 32;
                    ar.getNotification().a(45, build, false);
                }
                g.pQN.a(282, 20, 1, false);
            }
            z2 = false;
        } else if (i == 2) {
            if (z) {
                z2 = true;
                ar.hold();
                aVar = new i.a(jVar.xFE);
                aVar.Ez(R.l.dTu);
                aVar.YG(jVar.xFE.getString(R.l.dTt));
                aVar.mi(false);
                aVar.EC(R.l.dTr).a(new j$4(jVar));
                aVar.akx().show();
                g.pQN.a(282, 2, 1, false);
            }
            z2 = false;
        } else {
            x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d cancel no space notification isShowLackSpaceNotification[%b]", new Object[]{Integer.valueOf(jVar.hashCode()), Boolean.valueOf(jVar.xFI)});
            if (jVar.xFI) {
                ar.getNotification().cancel(45);
                jVar.xFI = false;
            }
            if (zf && z) {
                h.a(jVar.xFE, jVar.getString(R.l.eIr), jVar.getString(R.l.eIs), jVar.getString(R.l.dEp), jVar.getString(R.l.dFt), new 5(jVar), null);
                g.pQN.a(282, 0, 1, false);
                z2 = true;
            }
            z2 = false;
        }
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space isShowAlert[%b]", new Object[]{Integer.valueOf(jVar.hashCode()), Boolean.valueOf(z2)});
        if (z2) {
            cft.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
        }
        if (!z2) {
            ar.Hg();
            if (((Boolean) c.CU().get(w.a.xoS, Boolean.valueOf(false))).booleanValue()) {
                ar.Hg();
                if (t.ov((String) c.CU().get(6, ""))) {
                    x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", new Object[]{(String) c.CU().get(6, "")});
                } else {
                    ar.Hg();
                    booleanValue = ((Boolean) c.CU().get(w.a.xoT, Boolean.valueOf(false))).booleanValue();
                    ar.Hg();
                    str = (String) c.CU().get(w.a.xoU, this.xFL.getString(R.l.dLh));
                    x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[]{Boolean.valueOf(z), r0, Boolean.valueOf(booleanValue), str});
                    if (booleanValue) {
                        h.a(this.xFL.xFE, str, this.xFL.getString(R.l.dGO), this.xFL.getString(R.l.dFU), this.xFL.getString(R.l.dEn), new 2(this, str), new 3(this));
                    } else {
                        h.a(this.xFL.xFE, str, this.xFL.getString(R.l.dGO), this.xFL.getString(R.l.dFU), false, new 1(this, str));
                    }
                }
                ar.Hg();
                c.CU().a(w.a.xoS, Boolean.valueOf(false));
                ar.Hg();
                c.CU().a(w.a.xoU, "");
                ar.Hg();
                c.CU().lH(true);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|doOnResumeCheck";
    }
}

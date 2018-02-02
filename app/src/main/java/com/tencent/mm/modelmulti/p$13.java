package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class p$13 extends BroadcastReceiver {
    final /* synthetic */ p hGP;

    p$13(p pVar) {
        this.hGP = pVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        boolean z = true;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    z = true;
                    break;
                }
                break;
            case -1886648615:
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    z = true;
                    break;
                }
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    z = false;
                    break;
                }
                break;
            case 505380757:
                if (action.equals("android.intent.action.TIME_SET")) {
                    z = true;
                    break;
                }
                break;
            case 1019184907:
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    z = true;
                    break;
                }
                break;
            case 1041332296:
                if (action.equals("android.intent.action.DATE_CHANGED")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                p.a(this.hGP, true);
                break;
            case true:
                p.a(this.hGP, false);
                break;
            case true:
                p.b(this.hGP, true);
                break;
            case true:
                p.b(this.hGP, false);
                break;
            case true:
            case true:
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder Action time change");
                HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_DAY_RECEIVER);
                return;
        }
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]";
        Object[] objArr = new Object[5];
        objArr[0] = action;
        objArr[1] = Boolean.valueOf(p.j(this.hGP));
        objArr[2] = Boolean.valueOf(p.k(this.hGP));
        objArr[3] = Long.valueOf(p.l(this.hGP));
        if (p.m(this.hGP) == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[4] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (p.m(this.hGP) == null && p.k(this.hGP) && !p.j(this.hGP)) {
            if (System.currentTimeMillis() - p.l(this.hGP) < p.n(this.hGP) * 60000) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[]{Long.valueOf(p.n(this.hGP))});
                return;
            }
            p.a(this.hGP, new 2(this, new c(this) {
                final /* synthetic */ p$13 hHa;

                {
                    this.hHa = r1;
                }

                public final void a(int i, c$a com_tencent_mm_modelmulti_c_a) {
                    p.a(this.hHa.hGP, System.currentTimeMillis());
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[]{Integer.valueOf(i), Long.valueOf(p.l(this.hHa.hGP)), p.o(this.hHa.hGP), com_tencent_mm_modelmulti_c_a});
                    p.a(this.hHa.hGP, null);
                    if (i == 0 && !com_tencent_mm_modelmulti_c_a.hEW) {
                        ar.Hg();
                        c.CU().a(a.xsV, Long.valueOf(p.l(this.hHa.hGP)));
                        ar.Hg();
                        c.CU().lH(false);
                        try {
                            p.b(this.hHa.hGP, com_tencent_mm_modelmulti_c_a);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "doReportSDInfo err!", new Object[0]);
                            g.pQN.a(418, 6, 1, true);
                        }
                    }
                }
            }));
            ar.Dm().g(p.m(this.hGP), p.p(this.hGP) * 60000);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[]{Long.valueOf(p.p(this.hGP))});
        } else if (p.m(this.hGP) != null) {
            ar.Dm().cfF().removeCallbacks(p.m(this.hGP));
            p.a(this.hGP, null);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[]{p.o(this.hGP)});
        } else if (p.o(this.hGP) != null) {
            p.o(this.hGP).hEW = true;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[]{p.o(this.hGP)});
            p.a(this.hGP, null);
        }
    }
}

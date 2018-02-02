package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class f {
    private static long xcY = 125829120;
    private static long xcZ = 314572800;
    ak fhK = new ak(new 1(this), true);
    private boolean initialized = false;
    boolean mrc = false;
    private long xda = 0;
    private long xdb = 0;
    private String xdc = null;
    private j xdd;

    public f(j jVar) {
        this.xdd = jVar;
    }

    public final void cT(String str, int i) {
        if (!bh.ov(str)) {
            if (!str.equals(this.xdc)) {
                stop();
            }
            x.i("MicroMsg.TrafficStatistic", "pack size: " + i);
            x.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", new Object[]{Long.valueOf(xcY)});
            xcY = Math.max((long) (i * 4), xcY);
            xcY = Math.min(xcZ, xcY);
            x.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", new Object[]{Long.valueOf(xcY)});
            if (!this.initialized) {
                if (this.xdd.mContext != null) {
                    this.mrc = an.isWifi(this.xdd.mContext);
                }
                this.fhK.J(30000, 30000);
                this.initialized = true;
                this.xdc = str;
            }
        }
    }

    public final void stop() {
        lw(true);
        this.fhK.TG();
        this.initialized = false;
    }

    final void lw(boolean z) {
        long j = 0;
        if (z || this.xda + this.xdb >= 524288) {
            if (this.xda + this.xdb > 0) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
                intent.putExtra("intent_extra_flow_stat_upstream", this.xda);
                intent.putExtra("intent_extra_flow_stat_downstream", this.xdb);
                if (this.xdd.mContext != null) {
                    this.mrc = an.isWifi(this.xdd.mContext);
                }
                intent.putExtra("intent_extra_flow_stat_is_wifi", this.mrc);
                if (this.xdd.mContext != null) {
                    this.xdd.mContext.sendBroadcast(intent, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
                }
            }
            if (bh.ov(this.xdc)) {
                x.e("MicroMsg.TrafficStatistic", "traffic is null!");
            } else {
                long r = i.r(this.xdc, this.xda, this.xdb);
                this.xda = 0;
                this.xdb = 0;
                j = r;
            }
            if (j >= xcY && this.xdd.ruR == 2) {
                x.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
                this.xdd.cancel();
            }
        }
    }

    public static boolean UE(String str) {
        if (i.UG(str) <= xcY) {
            return false;
        }
        x.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
        return true;
    }
}

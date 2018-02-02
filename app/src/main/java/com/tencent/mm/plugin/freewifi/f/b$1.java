package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class b$1 implements Runnable {
    final /* synthetic */ int mGe;

    b$1(int i) {
        this.mGe = i;
    }

    public final void run() {
        if (b.ya()) {
            if (this.mGe == 0) {
                long currentTimeMillis = System.currentTimeMillis() - i$a.mCp.ow("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
                x.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : " + currentTimeMillis);
                if (currentTimeMillis < 0 || currentTimeMillis > 86400000) {
                    i$a.mCp.A("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
                } else {
                    x.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
                    return;
                }
            }
            b.bc(false);
            i aLQ = j.aLQ();
            m.a("FreeWifiLog", f.mGh, aLQ, "MicroMsg.FreeWifi.FreeWifiLogStorage");
            LinkedList aMr = aLQ.aMr();
            String str = "ServerReportSimpleLog:" + b.L(aMr);
            m.AG(str);
            x.i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
            if (aMr.size() > 0) {
                new e(aMr).b(new 1(this));
            } else {
                b.bc(true);
            }
        }
    }
}

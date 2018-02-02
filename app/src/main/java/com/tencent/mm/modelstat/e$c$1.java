package com.tencent.mm.modelstat;

import android.net.wifi.ScanResult;
import com.tencent.mm.modelstat.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.List;

class e$c$1 implements Runnable {
    final /* synthetic */ c hRq;

    e$c$1(c cVar) {
        this.hRq = cVar;
    }

    public final void run() {
        x.i("MicroMsg.IndoorReporter", "start wifi");
        while (this.hRq.hRo) {
            try {
                int i;
                long Wp = bh.Wp();
                List scanResults = this.hRq.bni.getScanResults();
                String str = "";
                if (scanResults == null || scanResults.size() <= 0) {
                    i = 0;
                } else {
                    Collections.sort(scanResults, new 1(this));
                    int i2 = 0;
                    i = 0;
                    while (i2 < scanResults.size()) {
                        int i3;
                        String str2;
                        ScanResult scanResult = (ScanResult) scanResults.get(i2);
                        if (scanResult != null && !bh.ov(scanResult.BSSID) && !bh.ov(scanResult.SSID)) {
                            str = str + scanResult.SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "") + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                            i3 = i + 1;
                            if (i3 >= this.hRq.hQL) {
                                i = i3;
                                break;
                            }
                            str2 = str;
                        } else {
                            i3 = i;
                            str2 = str;
                        }
                        i2++;
                        str = str2;
                        i = i3;
                    }
                }
                x.i("MicroMsg.IndoorReporter", "%d %s", new Object[]{Integer.valueOf(((Wp - this.hRq.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str).length()), (Wp - this.hRq.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str});
                this.hRq.hRp.add(r0);
                this.hRq.bni.startScan();
                Thread.sleep((long) this.hRq.hRn);
            } catch (Exception e) {
                x.e("MicroMsg.IndoorReporter", "Except:%s", new Object[]{e.getMessage()});
                return;
            }
        }
    }
}

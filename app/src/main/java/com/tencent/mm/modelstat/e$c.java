package com.tencent.mm.modelstat;

import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class e$c {
    WifiManager bni;
    int hQL = 0;
    final /* synthetic */ e hQT;
    int hRn = 0;
    boolean hRo = false;
    List<String> hRp = new ArrayList();
    long startTime = 0;
    Thread thread = e.b(new 1(this), "MicroMsg.IndoorReporter_WIFI_Scan");

    e$c(e eVar) {
        this.hQT = eVar;
    }

    public final String ST() {
        this.hRo = false;
        try {
            if (this.thread != null && this.thread.isAlive()) {
                this.thread.join(500);
            }
        } catch (Exception e) {
            x.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[]{e.getMessage()});
        }
        String str = this.hRp.size() + ";#";
        int i = false;
        while (i < this.hRp.size()) {
            String str2 = str + ((String) this.hRp.get(i)) + "#";
            i++;
            str = str2;
        }
        return str;
    }
}

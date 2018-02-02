package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.freewifi.ui.c.1;
import com.tencent.mm.plugin.freewifi.ui.c.2;
import com.tencent.mm.plugin.freewifi.ui.c.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static void wW() {
        try {
            c aMF = c.aMF();
            a 1 = new 1();
            if (!aMF.bgH) {
                aMF.bgH = true;
                aMF.mHF = c.OP();
                if (aMF.mHF == null) {
                    x.e(c.TAG, "doGeoLocation fail, iGetLocation is null");
                    return;
                }
                if (aMF.jky == null) {
                    aMF.jky = new 1(aMF, 1);
                }
                if (aMF.mHG == null) {
                    aMF.mHG = new af(Looper.myLooper());
                }
                aMF.mHG.postDelayed(new 2(aMF), 20000);
                aMF.mHF.a(aMF.jky);
            }
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e.getMessage());
        }
    }
}

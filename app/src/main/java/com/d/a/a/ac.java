package com.d.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;

final class ac extends e {
    private final WifiManager bni;

    ac(WifiManager wifiManager, Handler handler) {
        super(handler);
        this.bni = wifiManager;
    }

    final void rV() {
        this.bni.startScan();
    }
}

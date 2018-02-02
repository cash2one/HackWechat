package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.x;

class FreeWifiStateUI$8 implements Runnable {
    final /* synthetic */ FreeWifiStateUI mIt;

    FreeWifiStateUI$8(FreeWifiStateUI freeWifiStateUI) {
        this.mIt = freeWifiStateUI;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[]{this.mIt.ssid});
        this.mIt.aMs();
    }
}

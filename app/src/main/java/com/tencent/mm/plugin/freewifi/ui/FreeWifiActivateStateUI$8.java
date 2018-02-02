package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.x;

class FreeWifiActivateStateUI$8 implements Runnable {
    final /* synthetic */ FreeWifiActivateStateUI mGy;

    FreeWifiActivateStateUI$8(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.mGy = freeWifiActivateStateUI;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[]{this.mGy.ssid});
        this.mGy.aMs();
    }
}

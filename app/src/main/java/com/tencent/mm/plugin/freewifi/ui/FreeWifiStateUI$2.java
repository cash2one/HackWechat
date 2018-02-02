package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ak.a;

class FreeWifiStateUI$2 implements a {
    final /* synthetic */ FreeWifiStateUI mIt;

    FreeWifiStateUI$2(FreeWifiStateUI freeWifiStateUI) {
        this.mIt = freeWifiStateUI;
    }

    public final boolean uF() {
        if (!d.AJ(this.mIt.ssid)) {
            return true;
        }
        this.mIt.a(State.CONNECTED);
        FreeWifiStateUI.b(this.mIt).TG();
        return false;
    }
}

package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ak.a;

class FreeWifiActivateStateUI$2 implements a {
    final /* synthetic */ FreeWifiActivateStateUI mGy;

    FreeWifiActivateStateUI$2(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.mGy = freeWifiActivateStateUI;
    }

    public final boolean uF() {
        if (!d.AJ(this.mGy.ssid)) {
            return true;
        }
        this.mGy.a(State.CONNECTED);
        FreeWifiActivateStateUI.b(this.mGy).TG();
        return false;
    }
}

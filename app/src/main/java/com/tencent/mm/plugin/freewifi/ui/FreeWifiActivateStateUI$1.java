package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FreeWifiActivateStateUI$1 implements a {
    final /* synthetic */ FreeWifiActivateStateUI mGy;

    FreeWifiActivateStateUI$1(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.mGy = freeWifiActivateStateUI;
    }

    public final boolean uF() {
        if (!bh.ov(this.mGy.ssid)) {
            FreeWifiActivateStateUI.a(this.mGy, this.mGy.aMt());
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{this.mGy.ssid, Integer.valueOf(FreeWifiActivateStateUI.a(this.mGy))});
            FreeWifiActivateStateUI.b(this.mGy).TG();
            if (FreeWifiActivateStateUI.a(this.mGy) != 2) {
                this.mGy.aMx();
                this.mGy.aMv();
                d.a(this.mGy.ssid, 3, this.mGy.getIntent());
            }
        }
        return false;
    }
}

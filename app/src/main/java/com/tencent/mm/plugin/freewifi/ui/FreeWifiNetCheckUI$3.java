package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class FreeWifiNetCheckUI$3 implements a {
    final /* synthetic */ FreeWifiNetCheckUI mIe;

    FreeWifiNetCheckUI$3(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        this.mIe = freeWifiNetCheckUI;
    }

    public final boolean uF() {
        this.mIe.mHV.sendEmptyMessage(1);
        return true;
    }
}

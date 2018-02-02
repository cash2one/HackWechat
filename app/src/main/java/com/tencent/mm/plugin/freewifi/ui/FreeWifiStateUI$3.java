package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class FreeWifiStateUI$3 implements a {
    final /* synthetic */ FreeWifiStateUI mIt;
    private int mIu = -999999999;

    FreeWifiStateUI$3(FreeWifiStateUI freeWifiStateUI) {
        this.mIt = freeWifiStateUI;
    }

    public final void a(String str, l lVar) {
        FreeWifiStateUI.a(this.mIt, this.mIt.aMt());
        if (this.mIu != FreeWifiStateUI.a(this.mIt)) {
            this.mIu = FreeWifiStateUI.a(this.mIt);
            this.mIt.pi(FreeWifiStateUI.a(this.mIt));
        }
    }
}

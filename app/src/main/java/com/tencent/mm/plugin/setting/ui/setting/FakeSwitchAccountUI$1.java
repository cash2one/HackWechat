package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class FakeSwitchAccountUI$1 implements a {
    final /* synthetic */ FakeSwitchAccountUI qhb;

    FakeSwitchAccountUI$1(FakeSwitchAccountUI fakeSwitchAccountUI) {
        this.qhb = fakeSwitchAccountUI;
    }

    public final boolean uF() {
        int a = FakeSwitchAccountUI.a(this.qhb);
        x.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", Integer.valueOf(FakeSwitchAccountUI.b(this.qhb)), Integer.valueOf(a));
        if (FakeSwitchAccountUI.b(this.qhb) == 0 || a == 0 || FakeSwitchAccountUI.b(this.qhb) == a) {
            FakeSwitchAccountUI.d(this.qhb);
            if (FakeSwitchAccountUI.c(this.qhb) <= 20) {
                return true;
            }
            FakeSwitchAccountUI.e(this.qhb);
            return false;
        } else if (FakeSwitchAccountUI.c(this.qhb) <= 0) {
            FakeSwitchAccountUI.d(this.qhb);
            return true;
        } else {
            FakeSwitchAccountUI.e(this.qhb);
            return false;
        }
    }
}

package com.tencent.mm.ui.account.mobile;

import java.util.TimerTask;

class MobileVerifyUI$1 extends TimerTask {
    final /* synthetic */ MobileVerifyUI xVi;

    MobileVerifyUI$1(MobileVerifyUI mobileVerifyUI) {
        this.xVi = mobileVerifyUI;
    }

    public final void run() {
        this.xVi.xUT.post(new 1(this));
    }
}

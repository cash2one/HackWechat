package com.tencent.mm.ui.transmit;

import com.tencent.mm.sdk.platformtools.ak.a;

class SendAppMessageWrapperUI$1 implements a {
    final /* synthetic */ SendAppMessageWrapperUI zpD;

    SendAppMessageWrapperUI$1(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        this.zpD = sendAppMessageWrapperUI;
    }

    public final boolean uF() {
        if (this.zpD.getWindow() != null && this.zpD.getWindow().getDecorView() != null && this.zpD.getWindow().getDecorView().getWindowToken() != null) {
            SendAppMessageWrapperUI.c(this.zpD);
            return false;
        } else if (SendAppMessageWrapperUI.a(this.zpD) >= 10) {
            return false;
        } else {
            SendAppMessageWrapperUI.b(this.zpD);
            return true;
        }
    }
}

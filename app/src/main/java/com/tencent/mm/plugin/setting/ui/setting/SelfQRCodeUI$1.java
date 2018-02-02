package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.FrameLayout.LayoutParams;

class SelfQRCodeUI$1 implements Runnable {
    final /* synthetic */ SelfQRCodeUI qhD;

    SelfQRCodeUI$1(SelfQRCodeUI selfQRCodeUI) {
        this.qhD = selfQRCodeUI;
    }

    public final void run() {
        int width = SelfQRCodeUI.a(this.qhD).getWidth();
        LayoutParams layoutParams = (LayoutParams) SelfQRCodeUI.a(this.qhD).getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        SelfQRCodeUI.a(this.qhD).setLayoutParams(layoutParams);
    }
}

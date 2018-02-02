package com.tencent.mm.plugin.fingerprint.ui;

class FingerPrintAuthUI$3 implements Runnable {
    final /* synthetic */ FingerPrintAuthUI mAe;

    FingerPrintAuthUI$3(FingerPrintAuthUI fingerPrintAuthUI) {
        this.mAe = fingerPrintAuthUI;
    }

    public final void run() {
        FingerPrintAuthUI.e(this.mAe).setVisibility(0);
    }
}

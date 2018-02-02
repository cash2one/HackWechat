package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.wallet_core.ui.g;

class FingerPrintAuthUI$2 implements Runnable {
    final /* synthetic */ FingerPrintAuthUI mAe;
    final /* synthetic */ boolean mAf;

    FingerPrintAuthUI$2(FingerPrintAuthUI fingerPrintAuthUI, boolean z) {
        this.mAe = fingerPrintAuthUI;
        this.mAf = z;
    }

    public final void run() {
        if (this.mAf) {
            FingerPrintAuthUI.a(this.mAe, g.a(this.mAe, false, null));
        } else if (FingerPrintAuthUI.d(this.mAe) != null && FingerPrintAuthUI.d(this.mAe).isShowing()) {
            FingerPrintAuthUI.d(this.mAe).dismiss();
            FingerPrintAuthUI.a(this.mAe, null);
        }
    }
}

package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.pluginsdk.wallet.a;

class FingerPrintAuthUI$1 implements a {
    final /* synthetic */ FingerPrintAuthUI mAe;

    FingerPrintAuthUI$1(FingerPrintAuthUI fingerPrintAuthUI) {
        this.mAe = fingerPrintAuthUI;
    }

    public final void ac(int i, String str) {
        this.mAe.dY(false);
        if (i == 0) {
            FingerPrintAuthUI.b(this.mAe);
            if (FingerPrintAuthUI.c(this.mAe)) {
                FingerPrintAuthUI.a(this.mAe, false);
                return;
            }
            return;
        }
        FingerPrintAuthUI.a(this.mAe, str, i);
    }
}

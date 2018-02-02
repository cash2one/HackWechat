package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintAuthTransparentUI$11 implements a {
    final /* synthetic */ FingerPrintAuthTransparentUI mzX;

    FingerPrintAuthTransparentUI$11(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.mzX = fingerPrintAuthTransparentUI;
    }

    public final void ac(int i, String str) {
        this.mzX.dY(false);
        if (i == 0) {
            x.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
            FingerPrintAuthTransparentUI.d(this.mzX);
            FingerPrintAuthTransparentUI.a(this.mzX, false);
            return;
        }
        FingerPrintAuthTransparentUI.a(this.mzX, str);
    }
}

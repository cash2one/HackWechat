package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FingerPrintAuthTransparentUI$8 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthTransparentUI mzX;

    FingerPrintAuthTransparentUI$8(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.mzX = fingerPrintAuthTransparentUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FingerPrintAuthTransparentUI.b(this.mzX, false);
    }
}

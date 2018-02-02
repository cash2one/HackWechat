package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class FingerPrintAuthTransparentUI$13 implements OnCancelListener {
    final /* synthetic */ FingerPrintAuthTransparentUI mzX;

    FingerPrintAuthTransparentUI$13(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.mzX = fingerPrintAuthTransparentUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        FingerPrintAuthTransparentUI.aKI();
        this.mzX.finish();
    }
}

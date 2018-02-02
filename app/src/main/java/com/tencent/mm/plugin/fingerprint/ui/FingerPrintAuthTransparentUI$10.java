package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;

class FingerPrintAuthTransparentUI$10 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthTransparentUI mzX;
    final /* synthetic */ CheckBox mzY;

    FingerPrintAuthTransparentUI$10(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, CheckBox checkBox) {
        this.mzX = fingerPrintAuthTransparentUI;
        this.mzY = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FingerPrintAuthTransparentUI.b(this.mzX, this.mzY.isChecked());
    }
}

package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintAuthTransparentUI$4 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthTransparentUI mzX;

    FingerPrintAuthTransparentUI$4(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.mzX = fingerPrintAuthTransparentUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
        FingerPrintAuthTransparentUI.d(this.mzX);
        FingerPrintAuthTransparentUI.a(this.mzX, false);
        dialogInterface.dismiss();
    }
}

package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintAuthTransparentUI$3 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthTransparentUI mzX;

    FingerPrintAuthTransparentUI$3(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.mzX = fingerPrintAuthTransparentUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
        dialogInterface.dismiss();
        this.mzX.finish();
    }
}

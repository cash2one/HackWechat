package com.tencent.mm.plugin.hce.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class HCETransparentUI$4 implements OnCancelListener {
    final /* synthetic */ HCETransparentUI nAu;

    HCETransparentUI$4(HCETransparentUI hCETransparentUI) {
        this.nAu = hCETransparentUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.HCETransparentUI", "alvinluo cancel by pressing back");
        HCETransparentUI.a(this.nAu, "system NFC switch not opened");
    }
}

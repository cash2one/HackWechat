package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintEntranceUI$1 implements OnClickListener {
    final /* synthetic */ FingerPrintEntranceUI mAi;

    FingerPrintEntranceUI$1(FingerPrintEntranceUI fingerPrintEntranceUI) {
        this.mAi = fingerPrintEntranceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
        FingerPrintEntranceUI.a(this.mAi);
        this.mAi.finish();
    }
}

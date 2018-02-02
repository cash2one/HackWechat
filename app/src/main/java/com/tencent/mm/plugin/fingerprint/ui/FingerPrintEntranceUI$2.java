package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FingerPrintEntranceUI$2 implements OnClickListener {
    final /* synthetic */ FingerPrintEntranceUI mAi;

    FingerPrintEntranceUI$2(FingerPrintEntranceUI fingerPrintEntranceUI) {
        this.mAi = fingerPrintEntranceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mAi.finish();
    }
}

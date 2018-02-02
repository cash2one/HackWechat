package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FingerPrintEntranceUI$4 implements OnClickListener {
    final /* synthetic */ FingerPrintEntranceUI mAi;

    FingerPrintEntranceUI$4(FingerPrintEntranceUI fingerPrintEntranceUI) {
        this.mAi = fingerPrintEntranceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mAi.finish();
    }
}

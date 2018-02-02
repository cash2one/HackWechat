package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.wallet_core.a;

class FingerPrintAuthUI$5 implements OnClickListener {
    final /* synthetic */ FingerPrintAuthUI mAe;

    FingerPrintAuthUI$5(FingerPrintAuthUI fingerPrintAuthUI) {
        this.mAe = fingerPrintAuthUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.c(this.mAe, new Bundle(), -1);
    }
}

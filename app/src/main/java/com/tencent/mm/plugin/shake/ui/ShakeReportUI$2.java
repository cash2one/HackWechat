package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShakeReportUI$2 implements OnClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$2(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ShakeReportUI.r(this.qsi) != null) {
            ShakeReportUI.r(this.qsi).cancel();
        }
    }
}

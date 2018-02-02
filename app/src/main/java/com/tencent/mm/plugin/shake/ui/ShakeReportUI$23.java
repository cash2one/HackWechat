package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShakeReportUI$23 implements OnClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$23(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ShakeReportUI.N(this.qsi);
        this.qsi.finish();
    }
}

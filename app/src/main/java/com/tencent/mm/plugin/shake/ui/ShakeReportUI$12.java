package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShakeReportUI$12 implements OnClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$12(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qsi.finish();
    }
}

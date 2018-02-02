package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ShakeReportUI$5 implements OnClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$5(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(View view) {
        ShakeReportUI.r(this.qsi).cancel();
    }
}

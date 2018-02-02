package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;

class ShakeReportUI$4 implements OnCancelListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$4(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Looper.myQueue().addIdleHandler(new 1(this));
    }
}

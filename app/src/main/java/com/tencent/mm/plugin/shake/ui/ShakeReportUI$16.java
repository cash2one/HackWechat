package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShakeReportUI$16 implements OnCancelListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$16(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        ShakeReportUI.b(this.qsi, true);
        ShakeReportUI.J(this.qsi);
        ShakeReportUI.K(this.qsi).setText("");
    }
}

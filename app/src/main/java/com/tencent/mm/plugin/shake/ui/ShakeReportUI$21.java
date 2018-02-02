package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShakeReportUI$21 implements OnClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$21(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qsi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        ShakeReportUI.N(this.qsi);
        this.qsi.finish();
    }
}

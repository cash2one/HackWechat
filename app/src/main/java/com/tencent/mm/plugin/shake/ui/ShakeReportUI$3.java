package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ShakeReportUI$3 implements OnCancelListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$3(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.Hg();
        c.CU().setInt(4118, 1);
        ShakeReportUI.s(this.qsi).setVisibility(8);
    }
}

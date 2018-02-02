package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppUpdaterUI$4 implements OnCancelListener {
    final /* synthetic */ AppUpdaterUI xcq;

    AppUpdaterUI$4(AppUpdaterUI appUpdaterUI) {
        this.xcq = appUpdaterUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        AppUpdaterUI.i(this.xcq);
    }
}

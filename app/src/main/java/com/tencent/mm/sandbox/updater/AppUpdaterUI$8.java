package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppUpdaterUI$8 implements OnCancelListener {
    final /* synthetic */ AppUpdaterUI xcq;

    AppUpdaterUI$8(AppUpdaterUI appUpdaterUI) {
        this.xcq = appUpdaterUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        AppUpdaterUI.g(this.xcq);
    }
}

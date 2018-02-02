package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AppUpdaterUI$3 implements OnClickListener {
    final /* synthetic */ AppUpdaterUI xcq;

    AppUpdaterUI$3(AppUpdaterUI appUpdaterUI) {
        this.xcq = appUpdaterUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AppUpdaterUI.i(this.xcq);
    }
}

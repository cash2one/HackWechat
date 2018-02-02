package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppInstallerUI$1 implements OnCancelListener {
    final /* synthetic */ AppInstallerUI xcj;

    AppInstallerUI$1(AppInstallerUI appInstallerUI) {
        this.xcj = appInstallerUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        AppInstallerUI.a(this.xcj);
    }
}

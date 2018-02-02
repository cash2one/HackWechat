package com.tencent.mm.plugin.appbrand.launching;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppBrandLaunchProxyUI$1 implements OnCancelListener {
    final /* synthetic */ AppBrandLaunchProxyUI jwO;

    AppBrandLaunchProxyUI$1(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        this.jwO = appBrandLaunchProxyUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.jwO.finish();
    }
}

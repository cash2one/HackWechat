package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppBrandIDCardUI$3 implements OnCancelListener {
    final /* synthetic */ AppBrandIDCardUI jNQ;

    AppBrandIDCardUI$3(AppBrandIDCardUI appBrandIDCardUI) {
        this.jNQ = appBrandIDCardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.jNQ.setResult(0);
        this.jNQ.finish();
    }
}

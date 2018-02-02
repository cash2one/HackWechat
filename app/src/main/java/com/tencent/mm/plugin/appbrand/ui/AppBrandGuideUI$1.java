package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AppBrandGuideUI$1 implements OnDismissListener {
    final /* synthetic */ AppBrandGuideUI jKG;

    AppBrandGuideUI$1(AppBrandGuideUI appBrandGuideUI) {
        this.jKG = appBrandGuideUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.jKG.finish();
    }
}

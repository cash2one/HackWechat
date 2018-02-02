package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;

class AppBrandUI$3 implements c {
    final /* synthetic */ AppBrandUI jMR;

    AppBrandUI$3(AppBrandUI appBrandUI) {
        this.jMR = appBrandUI;
    }

    public final void finish() {
        this.jMR.mController.xIM.finish();
    }

    public final void a(AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppBrandUI.a(this.jMR, appBrandRemoteTaskController);
    }
}

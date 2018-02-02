package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class AppBrandInputInvokeHandler$4 implements OnKeyListener {
    final /* synthetic */ AppBrandInputInvokeHandler jXc;

    AppBrandInputInvokeHandler$4(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jXc = appBrandInputInvokeHandler;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        AppBrandInputInvokeHandler.access$602(this.jXc, 67 == i);
        if (AppBrandInputInvokeHandler.access$600(this.jXc)) {
            AppBrandInputInvokeHandler.access$1300(this.jXc).removeCallbacks(AppBrandInputInvokeHandler.access$1200(this.jXc));
            AppBrandInputInvokeHandler.access$1300(this.jXc).postDelayed(AppBrandInputInvokeHandler.access$1200(this.jXc), 1000);
        } else {
            AppBrandInputInvokeHandler.access$1200(this.jXc).run();
        }
        return false;
    }
}

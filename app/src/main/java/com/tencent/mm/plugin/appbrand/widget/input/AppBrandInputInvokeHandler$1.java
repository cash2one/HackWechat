package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.ui.j;

class AppBrandInputInvokeHandler$1 implements OnFocusChangeListener {
    final /* synthetic */ AppBrandInputInvokeHandler jXc;

    AppBrandInputInvokeHandler$1(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jXc = appBrandInputInvokeHandler;
    }

    public final void onFocusChange(View view, boolean z) {
        AppBrandInputInvokeHandler.access$000(this.jXc, z);
        Object obj = (!z || (AppBrandInputInvokeHandler.access$100(this.jXc).kbE && !j.bK(AppBrandInputInvokeHandler.access$200(this.jXc)))) ? null : 1;
        if (obj != null && AppBrandInputInvokeHandler.access$200(this.jXc) != null && AppBrandInputInvokeHandler.access$300(this.jXc) != null) {
            AppBrandInputInvokeHandler.access$200(this.jXc).requestFocus();
            AppBrandInputInvokeHandler.access$300(this.jXc).show();
        }
    }
}

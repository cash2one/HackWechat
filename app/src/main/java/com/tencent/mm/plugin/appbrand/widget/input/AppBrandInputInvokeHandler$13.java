package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.page.p;

class AppBrandInputInvokeHandler$13 implements OnClickListener {
    final /* synthetic */ AppBrandInputInvokeHandler jXc;

    AppBrandInputInvokeHandler$13(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jXc = appBrandInputInvokeHandler;
    }

    public final void onClick(View view) {
        if (AppBrandInputInvokeHandler.access$200(this.jXc) != null) {
            if (AppBrandInputInvokeHandler.access$200(this.jXc).hasFocus()) {
                AppBrandInputInvokeHandler.access$800(this.jXc);
                return;
            }
            p pVar = this.jXc.mPageRef == null ? null : (p) this.jXc.mPageRef.get();
            if (pVar != null) {
                g.amA().o(pVar.jDS);
            }
            if (AppBrandInputInvokeHandler.access$200(this.jXc) != null && view == AppBrandInputInvokeHandler.access$200(this.jXc)) {
                AppBrandInputInvokeHandler.access$200(this.jXc).setFocusable(true);
                AppBrandInputInvokeHandler.access$200(this.jXc).setFocusableInTouchMode(true);
                AppBrandInputInvokeHandler.access$300(this.jXc).jYF = AppBrandInputInvokeHandler.access$200(this.jXc);
                AppBrandInputInvokeHandler.access$200(this.jXc).requestFocus();
            }
        }
    }
}

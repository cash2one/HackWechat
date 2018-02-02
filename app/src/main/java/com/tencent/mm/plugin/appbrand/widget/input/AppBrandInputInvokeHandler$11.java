package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandInputInvokeHandler$11 implements b {
    final /* synthetic */ AppBrandInputInvokeHandler jXc;

    AppBrandInputInvokeHandler$11(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jXc = appBrandInputInvokeHandler;
    }

    public final void aen() {
        if (AppBrandInputInvokeHandler.access$200(this.jXc) != null) {
            x.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", AppBrandInputInvokeHandler.access$200(this.jXc).getEditableText());
            AppBrandInputInvokeHandler.access$400(this.jXc).a(AppBrandInputInvokeHandler.access$200(this.jXc).getEditableText(), false);
        }
    }
}

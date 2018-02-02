package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.j;

class AppBrandInputInvokeHandler$10 extends j {
    final /* synthetic */ AppBrandInputInvokeHandler jXc;

    AppBrandInputInvokeHandler$10(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jXc = appBrandInputInvokeHandler;
    }

    public final void afterTextChanged(Editable editable) {
        if (this.jXc.mPageRef != null && this.jXc.mPageRef.get() != null && AppBrandInputInvokeHandler.access$200(this.jXc) != null) {
            AppBrandInputInvokeHandler.access$700(this.jXc);
            if (af.t(editable)) {
                x.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", editable);
                return;
            }
            x.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", editable);
            AppBrandInputInvokeHandler.access$400(this.jXc).a(AppBrandInputInvokeHandler.access$200(this.jXc).getEditableText(), AppBrandInputInvokeHandler.access$600(this.jXc));
        }
    }
}

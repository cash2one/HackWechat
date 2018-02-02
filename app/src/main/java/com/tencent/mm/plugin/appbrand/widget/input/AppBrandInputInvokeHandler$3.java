package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.c;
import com.tencent.mm.plugin.appbrand.widget.input.u.e;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandInputInvokeHandler$3 implements e {
    final /* synthetic */ AppBrandInputInvokeHandler jXc;

    AppBrandInputInvokeHandler$3(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jXc = appBrandInputInvokeHandler;
    }

    public final void kf(int i) {
        x.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[]{Integer.valueOf(i)});
        if (i != 2) {
            if (i == 0 && AppBrandInputInvokeHandler.access$200(this.jXc) != null) {
                AppBrandInputInvokeHandler.access$200(this.jXc).requestFocus();
            }
            AppBrandInputInvokeHandler.access$1100(this.jXc);
            if (this.jXc.mPageRef != null && this.jXc.mPageRef.get() != null) {
                m.a((p) this.jXc.mPageRef.get(), AppBrandInputInvokeHandler.access$200(this.jXc));
                return;
            }
            return;
        }
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.jXc, c.jXe);
        AppBrandInputInvokeHandler.access$1000(this.jXc);
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.jXc, 0);
    }
}

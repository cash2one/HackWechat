package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler$a;

class c$2 implements AppBrandInputInvokeHandler$a {
    final /* synthetic */ AppBrandInputInvokeHandler jjV;
    final /* synthetic */ c jjW;

    c$2(c cVar, AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.jjW = cVar;
        this.jjV = appBrandInputInvokeHandler;
    }

    public final void cL(boolean z) {
        if (z) {
            p kx = c.kx(this.jjV.getInputId());
            if (kx != null && !kx.isRunning()) {
            }
        }
    }
}

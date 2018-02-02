package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import java.lang.ref.WeakReference;

class f$4 implements Runnable {
    final /* synthetic */ AppBrandInputInvokeHandler jjV;
    final /* synthetic */ WeakReference jjX;
    final /* synthetic */ f jkd;
    final /* synthetic */ e jke;
    final /* synthetic */ int jkg;
    final /* synthetic */ int jkh;

    f$4(f fVar, WeakReference weakReference, AppBrandInputInvokeHandler appBrandInputInvokeHandler, e eVar, int i, int i2) {
        this.jkd = fVar;
        this.jjX = weakReference;
        this.jjV = appBrandInputInvokeHandler;
        this.jke = eVar;
        this.jkg = i;
        this.jkh = i2;
    }

    public final void run() {
        p pVar = (p) this.jjX.get();
        if (pVar != null && pVar.jDS != null) {
            g.amA().o(pVar.jDS);
            this.jjV.insertInput(this.jke, this.jkg, this.jkh);
        }
    }
}

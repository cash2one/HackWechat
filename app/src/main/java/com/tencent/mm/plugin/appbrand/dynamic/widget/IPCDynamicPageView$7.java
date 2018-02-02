package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.mm.modelappbrand.f;

class IPCDynamicPageView$7 implements Runnable {
    final /* synthetic */ IPCDynamicPageView iVu;
    final /* synthetic */ f iVw;
    final /* synthetic */ int iVx;

    IPCDynamicPageView$7(IPCDynamicPageView iPCDynamicPageView, f fVar, int i) {
        this.iVu = iPCDynamicPageView;
        this.iVw = fVar;
        this.iVx = i;
    }

    public final void run() {
        this.iVw.q(this.iVu, this.iVx);
    }
}

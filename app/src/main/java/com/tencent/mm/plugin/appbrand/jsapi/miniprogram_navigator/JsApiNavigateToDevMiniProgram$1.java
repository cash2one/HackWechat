package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.j;

class JsApiNavigateToDevMiniProgram$1 implements b {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiNavigateToDevMiniProgram jol;

    JsApiNavigateToDevMiniProgram$1(JsApiNavigateToDevMiniProgram jsApiNavigateToDevMiniProgram, j jVar, int i) {
        this.jol = jsApiNavigateToDevMiniProgram;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void cO(boolean z) {
        this.iZy.E(this.gOK, this.jol.e(z ? "ok" : "fail", null));
    }
}

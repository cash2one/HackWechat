package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.pluginsdk.model.app.g.a;

class JsApiLaunchApplication$a implements a {
    volatile boolean fze;
    volatile boolean hns;
    volatile boolean jdp;
    volatile boolean jdq;
    a jdr;

    JsApiLaunchApplication$a(a aVar) {
        this.jdr = aVar;
    }

    public final void cG(boolean z) {
        this.hns = true;
        this.jdp = z;
        if (this.jdq && this.jdr != null) {
            this.jdr.n(this.fze, z);
        }
    }

    final void cH(boolean z) {
        this.fze = z;
        this.jdq = true;
        if (this.hns && this.jdr != null) {
            this.jdr.n(z, this.jdp);
        }
    }
}

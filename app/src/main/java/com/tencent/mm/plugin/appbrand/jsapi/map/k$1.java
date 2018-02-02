package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.compat.a.b;

class k$1 implements Runnable {
    final /* synthetic */ b jmc;
    final /* synthetic */ k jmo;

    k$1(k kVar, b bVar) {
        this.jmo = kVar;
        this.jmc = bVar;
    }

    public final void run() {
        if (this.jmc != null) {
            this.jmc.getView().setVisibility(8);
            this.jmc.clean();
        }
    }
}

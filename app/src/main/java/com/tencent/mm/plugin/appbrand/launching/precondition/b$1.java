package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;

class b$1 implements Runnable {
    final /* synthetic */ b jyT;

    b$1(b bVar) {
        this.jyT = bVar;
    }

    public final void run() {
        ((AppBrandLaunchProxyUI) this.jyT.getBaseContext()).finish();
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.video;

class c$1 implements Runnable {
    final /* synthetic */ AppBrandVideoView jtm;
    final /* synthetic */ c jto;

    c$1(c cVar, AppBrandVideoView appBrandVideoView) {
        this.jto = cVar;
        this.jtm = appBrandVideoView;
    }

    public final void run() {
        this.jtm.clean();
    }
}

package com.tencent.mm.plugin.appbrand.ipc;

class AppBrandProcessProxyUI$4 implements Runnable {
    final /* synthetic */ AppBrandProcessProxyUI jbf;
    final /* synthetic */ AppBrandProxyUIProcessTask$ProcessResult jbg;

    AppBrandProcessProxyUI$4(AppBrandProcessProxyUI appBrandProcessProxyUI, AppBrandProxyUIProcessTask$ProcessResult appBrandProxyUIProcessTask$ProcessResult) {
        this.jbf = appBrandProcessProxyUI;
        this.jbg = appBrandProxyUIProcessTask$ProcessResult;
    }

    public final void run() {
        this.jbf.b(this.jbg);
        this.jbf.finish();
    }
}

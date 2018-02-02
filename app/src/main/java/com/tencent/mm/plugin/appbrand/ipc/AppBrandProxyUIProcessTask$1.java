package com.tencent.mm.plugin.appbrand.ipc;

class AppBrandProxyUIProcessTask$1 implements Runnable {
    final /* synthetic */ AppBrandProxyUIProcessTask$ProcessResult jbg;
    final /* synthetic */ AppBrandProxyUIProcessTask jbr;

    AppBrandProxyUIProcessTask$1(AppBrandProxyUIProcessTask appBrandProxyUIProcessTask, AppBrandProxyUIProcessTask$ProcessResult appBrandProxyUIProcessTask$ProcessResult) {
        this.jbr = appBrandProxyUIProcessTask;
        this.jbg = appBrandProxyUIProcessTask$ProcessResult;
    }

    public final void run() {
        if (this.jbr.jbq != null) {
            this.jbr.jbq.a(this.jbg);
        }
    }
}

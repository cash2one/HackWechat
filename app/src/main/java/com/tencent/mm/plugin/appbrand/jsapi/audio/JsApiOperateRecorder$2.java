package com.tencent.mm.plugin.appbrand.jsapi.audio;

class JsApiOperateRecorder$2 implements Runnable {
    final /* synthetic */ JsApiOperateRecorder jfi;
    final /* synthetic */ boolean jfj;

    JsApiOperateRecorder$2(JsApiOperateRecorder jsApiOperateRecorder, boolean z) {
        this.jfi = jsApiOperateRecorder;
        this.jfj = z;
    }

    public final void run() {
        JsApiOperateRecorder.a(this.jfi, this.jfj);
    }
}

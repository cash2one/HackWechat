package com.tencent.mm.plugin.appbrand.jsapi.audio;

class JsApiStartRecordVoice$3 implements Runnable {
    final /* synthetic */ JsApiStartRecordVoice jfH;
    final /* synthetic */ boolean jfj;

    JsApiStartRecordVoice$3(JsApiStartRecordVoice jsApiStartRecordVoice, boolean z) {
        this.jfH = jsApiStartRecordVoice;
        this.jfj = z;
    }

    public final void run() {
        JsApiStartRecordVoice.a(this.jfH, this.jfj);
    }
}

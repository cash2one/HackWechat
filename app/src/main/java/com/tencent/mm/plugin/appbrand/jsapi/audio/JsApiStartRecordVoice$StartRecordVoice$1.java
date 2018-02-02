package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice;
import com.tencent.mm.plugin.appbrand.media.b;
import com.tencent.mm.plugin.appbrand.media.b.a;

class JsApiStartRecordVoice$StartRecordVoice$1 implements Runnable {
    final /* synthetic */ StartRecordVoice jfK;

    JsApiStartRecordVoice$StartRecordVoice$1(StartRecordVoice startRecordVoice) {
        this.jfK = startRecordVoice;
    }

    public final void run() {
        StartRecordVoice.a(this.jfK, b.a(StartRecordVoice.a(this.jfK), new a(this) {
            final /* synthetic */ JsApiStartRecordVoice$StartRecordVoice$1 jfL;

            {
                this.jfL = r1;
            }

            public final void kq(int i) {
                StartRecordVoice.a(this.jfL.jfK, i);
                StartRecordVoice.b(this.jfL.jfK);
            }
        }, StartRecordVoice.c(this.jfK) * 1000));
        if (!StartRecordVoice.d(this.jfK)) {
            StartRecordVoice.e(this.jfK);
        }
    }
}

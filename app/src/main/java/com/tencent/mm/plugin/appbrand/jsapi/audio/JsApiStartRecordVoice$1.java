package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p.d;

class JsApiStartRecordVoice$1 implements d {
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiStartRecordVoice jfH;

    JsApiStartRecordVoice$1(JsApiStartRecordVoice jsApiStartRecordVoice, j jVar) {
        this.jfH = jsApiStartRecordVoice;
        this.iZy = jVar;
    }

    public final void afA() {
        JsApiStopRecordVoice.d(this.iZy);
        JsApiStartRecordVoice.a(this.jfH).b((d) this);
    }
}

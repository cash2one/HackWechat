package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;

class JsApiChooseVideo$1 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiChooseVideo jnq;

    JsApiChooseVideo$1(JsApiChooseVideo jsApiChooseVideo, j jVar) {
        this.jnq = jsApiChooseVideo;
        this.iZy = jVar;
    }

    public final void onResume() {
        JsApiChooseVideo.ID();
        c.b(this.iZy.mAppId, this);
    }
}

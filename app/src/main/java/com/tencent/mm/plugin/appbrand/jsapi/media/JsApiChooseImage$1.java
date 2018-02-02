package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;

class JsApiChooseImage$1 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiChooseImage jmF;

    JsApiChooseImage$1(JsApiChooseImage jsApiChooseImage, j jVar) {
        this.jmF = jsApiChooseImage;
        this.iZy = jVar;
    }

    public final void onResume() {
        JsApiChooseImage.ID();
        c.b(this.iZy.mAppId, this);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;

class JsApiChooseMedia$1 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiChooseMedia jmY;

    JsApiChooseMedia$1(JsApiChooseMedia jsApiChooseMedia, j jVar) {
        this.jmY = jsApiChooseMedia;
        this.iZy = jVar;
    }

    public final void onResume() {
        x.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
        JsApiChooseMedia.ID();
        c.b(this.iZy.mAppId, this);
    }
}

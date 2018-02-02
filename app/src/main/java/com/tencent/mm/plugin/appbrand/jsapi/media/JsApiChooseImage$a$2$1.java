package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.2;
import java.util.ArrayList;

class JsApiChooseImage$a$2$1 implements Runnable {
    final /* synthetic */ ArrayList jmV;
    final /* synthetic */ 2 jmW;

    JsApiChooseImage$a$2$1(2 2, ArrayList arrayList) {
        this.jmW = 2;
        this.jmV = arrayList;
    }

    public final void run() {
        this.jmW.jmQ.jmM.bjW = -1;
        this.jmW.jmQ.jmM.jmK = this.jmV;
        a.b(this.jmW.jmQ, this.jmW.jmQ.jmM);
    }
}

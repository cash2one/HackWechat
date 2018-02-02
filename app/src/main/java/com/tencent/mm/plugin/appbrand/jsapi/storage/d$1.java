package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.j;
import java.util.HashMap;
import java.util.Map;

class d$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiGetStorageInfoTask jrq;
    final /* synthetic */ d jrr;

    d$1(d dVar, JsApiGetStorageInfoTask jsApiGetStorageInfoTask, j jVar, int i) {
        this.jrr = dVar;
        this.jrq = jsApiGetStorageInfoTask;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("keys", this.jrq.jrs);
        hashMap.put("currentSize", Integer.valueOf(this.jrq.size));
        hashMap.put("limitSize", Integer.valueOf(this.jrq.asN));
        this.iZy.E(this.gOK, this.jrr.e("ok", hashMap));
    }
}

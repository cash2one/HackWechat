package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.j;

class i$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiSetStorageTask jrx;
    final /* synthetic */ i jry;

    i$1(i iVar, j jVar, int i, JsApiSetStorageTask jsApiSetStorageTask) {
        this.jry = iVar;
        this.iZy = jVar;
        this.gOK = i;
        this.jrx = jsApiSetStorageTask;
    }

    public final void run() {
        this.iZy.E(this.gOK, this.jry.e(this.jrx.result, null));
        this.jrx.afj();
    }
}

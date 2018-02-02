package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class c$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ long gyu;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiGetStorageTask jro;
    final /* synthetic */ c jrp;

    c$1(c cVar, JsApiGetStorageTask jsApiGetStorageTask, j jVar, int i, long j) {
        this.jrp = cVar;
        this.jro = jsApiGetStorageTask;
        this.iZy = jVar;
        this.gOK = i;
        this.gyu = j;
    }

    public final void run() {
        String str = this.jro.value == null ? "fail" : "ok";
        Map hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.jro.value == null ? "" : this.jro.value);
        hashMap.put("dataType", this.jro.type == null ? "" : this.jro.type);
        this.iZy.E(this.gOK, this.jrp.e(str, hashMap));
        this.jro.afj();
        x.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", new Object[]{this.jro.aAM, Long.valueOf(System.currentTimeMillis() - this.gyu)});
    }
}

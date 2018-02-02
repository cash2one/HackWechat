package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

class a$1 implements Runnable {
    final /* synthetic */ j iZy;
    final /* synthetic */ String jbj;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ a jor;

    a$1(a aVar, j jVar, JSONObject jSONObject, String str) {
        this.jor = aVar;
        this.iZy = jVar;
        this.jel = jSONObject;
        this.jbj = str;
    }

    public final void run() {
        this.jor.a(this.iZy, this.jel, this.jbj);
    }
}

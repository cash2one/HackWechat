package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class a$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ a jiB;

    a$1(a aVar, j jVar, int i, JSONObject jSONObject) {
        this.jiB = aVar;
        this.iZy = jVar;
        this.gOK = i;
        this.jel = jSONObject;
    }

    public final void run() {
        p b = a.b(this.iZy);
        if (b == null) {
            x.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
            this.iZy.E(this.gOK, this.jiB.e("fail", null));
        } else if (b.irP.Yz()) {
            a a = a.a(b, this.jel, false);
            this.iZy.E(this.gOK, this.jiB.e(a.fnL, a.values));
        } else {
            a.a(this.jiB, this.iZy, this.jel, this.gOK);
        }
    }
}

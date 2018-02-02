package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.jsapi.map.m.1;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class m$1$1 implements Runnable {
    final /* synthetic */ 1 jmy;

    m$1$1(1 1) {
        this.jmy = 1;
    }

    public final void run() {
        synchronized (this) {
            final JSONObject jSONObject = (JSONObject) m.agw().pollFirst();
            if (jSONObject != null) {
                x.d("MicroMsg.JsApiTranslateMapMarker", "run, start post next animator!");
                c.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ m$1$1 jmA;

                    public final void run() {
                        m.a(this.jmA.jmy.jmx, jSONObject);
                    }
                });
            } else {
                x.d("MicroMsg.JsApiTranslateMapMarker", "run, animator end!");
                m.a(this.jmy.jmx).sj(this.jmy.jmx.e("ok", null));
                m.b(this.jmy.jmx).anD();
            }
        }
    }
}

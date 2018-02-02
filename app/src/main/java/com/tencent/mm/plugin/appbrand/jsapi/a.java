package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.l;
import org.json.JSONObject;

public class a extends e {
    public void a(c cVar, JSONObject jSONObject, int i) {
        if (cVar instanceof j) {
            if (l.a((j) cVar, jSONObject, (b) this)) {
                a((j) cVar, jSONObject, i);
            } else {
                cVar.E(i, e(this.jbZ, null));
            }
        } else if (cVar instanceof p) {
            a((p) cVar, jSONObject, i);
        }
    }

    public void a(j jVar, JSONObject jSONObject, int i) {
    }

    public void a(p pVar, JSONObject jSONObject, int i) {
    }
}

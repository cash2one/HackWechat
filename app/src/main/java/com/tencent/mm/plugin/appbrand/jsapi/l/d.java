package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 197;
    private static final String NAME = "setStatusBarStyle";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("color", "");
        p b = b(jVar);
        if (b == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        if (optString.equals("white")) {
            b.rU("white");
        } else if (optString.equals("black")) {
            b.rU("black");
        }
        jVar.E(i, e("ok", null));
    }
}

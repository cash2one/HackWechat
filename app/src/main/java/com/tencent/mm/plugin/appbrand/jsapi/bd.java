package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class bd extends a {
    public static final int CTRL_INDEX = 8;
    public static final String NAME = "setNavigationBarTitle";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("title");
        p b = b(jVar);
        if (b == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        b.rS(optString);
        jVar.E(i, e("ok", null));
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class ae extends a {
    public static final int CTRL_INDEX = 10;
    public static final String NAME = "hideNavigationBarLoading";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        p b = b(jVar);
        if (b == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        b.cA(false);
        jVar.E(i, e("ok", null));
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 146;
    public static final String NAME = "showShareMenu";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        p b = b(jVar);
        if (b != null) {
            b.x(m.jAH, false);
        }
        jVar.E(i, e("ok", null));
    }
}

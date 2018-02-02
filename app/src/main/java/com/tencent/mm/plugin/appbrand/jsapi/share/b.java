package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 203;
    public static final String NAME = "hideShareMenu";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiHideShareMenu", "invoke");
        p b = b(jVar);
        if (b != null) {
            b.x(m.jAH, true);
        }
        jVar.E(i, e("ok", null));
    }
}

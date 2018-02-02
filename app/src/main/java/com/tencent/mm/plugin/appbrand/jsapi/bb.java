package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bb extends a {
    public static final int CTRL_INDEX = 388;
    public static final String NAME = "setMenuStyle";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiSetMenuStyle", "JsApiSetMenuStyle!");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiSetMenuStyle", "data is null");
            return;
        }
        String optString = jSONObject.optString("style");
        p b = b(jVar);
        if (b == null) {
            jVar.E(i, e("fail view is null", null));
            return;
        }
        if (optString.equalsIgnoreCase("dark")) {
            b.tL("dark");
        } else if (optString.equalsIgnoreCase("light")) {
            b.tL("light");
        } else {
            jVar.E(i, e("fail invalid style " + optString, null));
            x.e("MicroMsg.JsApiSetMenuStyle", "fail invalid style %s", new Object[]{optString});
            return;
        }
        jVar.E(i, e("ok", null));
    }
}

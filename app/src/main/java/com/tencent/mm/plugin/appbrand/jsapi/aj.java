package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class aj extends a {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        jVar.irP.iqC.ld(jSONObject.optInt("delta", 1));
        jVar.E(i, e("ok", null));
    }
}

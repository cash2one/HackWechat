package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class ag extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "initReady";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        pVar.onReady();
    }
}

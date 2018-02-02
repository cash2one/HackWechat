package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.6;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 252;
    public static final String NAME = "navigateBackMiniProgram";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        e eVar = jVar.irP;
        eVar.iqt.runOnUiThread(new 6(eVar, optJSONObject));
    }
}

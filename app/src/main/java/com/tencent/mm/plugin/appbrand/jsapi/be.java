package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class be extends a {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";
    float jej = Float.NaN;
    float jek;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
            return;
        }
        ag.y(new 1(this, jSONObject, jVar, i));
    }
}

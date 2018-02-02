package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.a.a;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.v.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class x extends l {
    public static final int CTRL_INDEX = 425;
    public static final String NAME = "getBatteryInfo";

    public final String a(j jVar, JSONObject jSONObject) {
        c alM = a.jSv.alM();
        JSONObject hVar = new h();
        try {
            hVar.put("level", alM.jSF);
            hVar.put("isCharging", alM.jSE);
        } catch (JSONException e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiGetBatteryInfo", "JSON put failed. [%s]", new Object[]{e});
        }
        return hVar.toString();
    }
}

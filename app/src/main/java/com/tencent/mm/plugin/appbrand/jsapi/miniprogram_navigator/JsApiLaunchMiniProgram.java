package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class JsApiLaunchMiniProgram extends a {
    public static final int CTRL_INDEX = 166;
    public static final String NAME = "launchMiniProgram";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        int i2 = 1;
        String optString = jSONObject.optString("appId", null);
        if (bh.ov(optString)) {
            jVar.E(i, e("fail:invalid data", null));
        } else if (optString.equals(jVar.mAppId)) {
            jVar.E(i, e("fail target appId is the same as the caller appId", null));
        } else {
            String optString2 = jSONObject.optString("path", null);
            String optString3 = jSONObject.optString("extraData", null);
            if (!(jVar.irP.iqx.iOI.iGK == 1 && jSONObject.optBoolean("isDev", false))) {
                i2 = 0;
            }
            ag.y(new 1(this, jVar, optString, i2, optString2, optString3, i));
        }
    }
}

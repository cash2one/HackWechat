package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class JsApiNavigateToDevMiniProgram extends a {
    private static final int CTRL_INDEX = 351;
    private static final String NAME = "navigateToDevMiniProgram";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("downloadURL");
        String optString3 = jSONObject.optString("checkSumMd5");
        a a = a.a(jSONObject.optString("envVersion"), a.jnW);
        String optString4 = jSONObject.optString("relativeURL");
        JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
        String optString5 = jSONObject.optString("extoptions");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail invalid appId", null));
        } else if (a.jnW == a && (bh.ov(optString2) || bh.ov(optString3))) {
            jVar.E(i, e("fail invalid downloadURL & checkSumMd5", null));
        } else {
            if (a.jnW == a) {
                DevPkgInfo devPkgInfo = new DevPkgInfo();
                devPkgInfo.appId = optString;
                devPkgInfo.fvR = optString2;
                devPkgInfo.fIn = optString3;
                devPkgInfo.jom = optString5;
                XIPCInvoker.a("com.tencent.mm", devPkgInfo, a.class);
            }
            e.a(jVar, optString, a.iKd, 0, optString4, null, optJSONObject, new 1(this, jVar, i));
        }
    }
}

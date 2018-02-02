package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting extends a {
    public static final int CTRL_INDEX = 228;
    public static final String NAME = "openWeRunSetting";
    private OpenWeRunSetting jdD;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        boolean z = true;
        if (jSONObject != null) {
            z = jSONObject.optBoolean("checkSupport", true);
        }
        this.jdD = new OpenWeRunSetting(this, jVar, i, z);
        this.jdD.afi();
        AppBrandMainProcessService.a(this.jdD);
    }
}

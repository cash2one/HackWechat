package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug;
import org.json.JSONObject;

public final class az extends a {
    public static final int CTRL_INDEX = 249;
    public static final String NAME = "setEnableDebug";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        boolean optBoolean = jSONObject.optBoolean("enableDebug", false);
        if (jVar.irP.iqx.iOi == optBoolean) {
            jVar.E(i, e("ok", null));
            return;
        }
        MenuDelegate_EnableDebug.e(jVar.getContext(), jVar.mAppId, optBoolean);
        jVar.E(i, e("ok", null));
    }
}

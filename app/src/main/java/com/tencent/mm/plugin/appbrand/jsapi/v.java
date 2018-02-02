package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class v extends a {
    public static final int CTRL_INDEX = 139;
    public static final String NAME = "disableScrollBounce";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject.has("disable")) {
            if (jSONObject.optBoolean("disable", false)) {
                pVar.cC(false);
            } else {
                pVar.cC(pVar.irP.iqy.qz(pVar.getURL()).iMZ);
            }
            pVar.E(i, e("ok", null));
            return;
        }
        pVar.E(i, e("ok", null));
    }
}

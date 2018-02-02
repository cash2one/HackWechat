package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.b;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        boolean optBoolean = jSONObject.optBoolean("hide", false);
        jSONObject.optString("text", "");
        jSONObject.optString("iconPath", "");
        int a = b.a(b(jVar), optBoolean);
        String str = "fail";
        switch (1.jrD[a - 1]) {
            case 1:
                str = "ok";
                break;
            case 2:
                str = "fail no page available";
                break;
            case 3:
                str = "fail iconPath not found";
                break;
            case 4:
                str = "fail invalid text length";
                break;
        }
        jVar.E(i, e(str, null));
    }
}

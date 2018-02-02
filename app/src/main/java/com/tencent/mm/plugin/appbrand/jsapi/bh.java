package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.l;
import org.json.JSONObject;

public final class bh extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setTabBarStyle";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        e eVar = jVar.irP.iqy.iMA;
        String optString = jSONObject.optString("color", eVar.hbM);
        String optString2 = jSONObject.optString("selectedColor", eVar.iMM);
        String optString3 = jSONObject.optString("backgroundColor", eVar.iMN);
        String optString4 = jSONObject.optString("borderStyle", eVar.iMO);
        l aiT = jVar.irP.iqC.aiT();
        if (aiT instanceof com.tencent.mm.plugin.appbrand.page.e) {
            ((com.tencent.mm.plugin.appbrand.page.e) aiT).jCV.g(optString, optString2, optString3, optString4);
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail:not TabBar page", null));
    }
}

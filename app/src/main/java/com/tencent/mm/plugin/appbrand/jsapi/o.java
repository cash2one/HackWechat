package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class o extends a {
    public static final int CTRL_INDEX = 58;
    public static final String NAME = "addCard";
    int jcs;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiAddCard", "mmActivity is null, invoke fail!");
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiAddCard", "cardList is null, invoke fail!");
            return;
        }
        this.jcs = i;
        a.jwN = new 1(this, jVar);
        intent.putExtra("key_in_card_list", optString);
        intent.putExtra("key_from_scene", 26);
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        if (!(appBrandSysConfig == null || appBrandSysConfig.iOI == null)) {
            intent.putExtra("key_from_appbrand_type", appBrandSysConfig.iOI.iGK);
        }
        d.b(a, "card", ".ui.CardAddEntranceUI", intent, 1);
    }
}

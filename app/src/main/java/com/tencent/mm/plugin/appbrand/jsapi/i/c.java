package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        p b = b(jVar);
        if (b == null) {
            x.w("MicroMsg.JsApiShowModal", "invoke JsApi JsApiShowModal failed, current page view is null.");
            jVar.E(i, e("fail", null));
            return;
        }
        m.o(b);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("confirmText", jVar.getContext().getString(q.j.dFU));
        String optString3 = jSONObject.optString("cancelText", jVar.getContext().getString(q.j.dEn));
        j jVar2 = jVar;
        ag.y(new 1(this, jVar2, optString, jSONObject.optString("content"), optString2, i, Boolean.valueOf(jSONObject.optBoolean("showCancel", true)), optString3, f.aP(jSONObject.optString("confirmColor", ""), Color.parseColor("#3CC51F")), f.aP(jSONObject.optString("cancelColor", ""), Color.parseColor("#000000"))));
    }
}

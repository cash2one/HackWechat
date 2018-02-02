package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class at extends a {
    public static final int CTRL_INDEX = 430;
    public static final String NAME = "pageNotFoundCallback";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiPageNotFoundCallback", "data is null, do nothing");
            jVar.E(i, e("fail", null));
            return;
        }
        x.i("MicroMsg.JsApiPageNotFoundCallback", "pageNotFoundCallback data:%s", new Object[]{jSONObject});
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("hasHandler"));
        int optInt = jSONObject.optInt("webviewId", -1);
        p b = b(jVar);
        if (valueOf.booleanValue()) {
            if (b != null) {
                ag.K(b.jEe);
                if (b.hashCode() != optInt) {
                    x.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView.getComponentId():%d, webviewId:%d, err", new Object[]{Integer.valueOf(b.hashCode()), Integer.valueOf(optInt)});
                }
            } else {
                x.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView is null");
            }
            x.i("MicroMsg.JsApiPageNotFoundCallback", "already handler, ignore");
            jVar.E(i, e("ok", null));
            return;
        }
        if (b != null && b.hashCode() == optInt) {
            ag.y(new 1(this, b));
        }
        x.e("MicroMsg.JsApiPageNotFoundCallback", "currentPageView is null, return");
        jVar.E(i, e("ok", null));
    }
}

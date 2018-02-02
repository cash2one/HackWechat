package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        MMActivity a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", jVar.mAppId);
            a.joW.a(a, jSONObject, new 1(this, jVar, i));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiVerifyPaymentPassword", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}

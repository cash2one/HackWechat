package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.3;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 86;
    public static final String NAME = "bindPaymentCard";

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
            a aVar = a.joW;
            MMActivity.a 3 = new 3(aVar, new 1(this, jVar, i));
            g gVar = new g(jSONObject);
            gVar.fCW = 4;
            h.b(a, gVar, aVar.hashCode() & 65535, 3);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiBindPaymentCard", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}

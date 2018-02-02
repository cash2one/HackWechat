package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.b$a;
import com.tencent.mm.z.u.b;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    private static String iSW = "com.tencent.mm:tools";

    public a() {
        super(d.NAME, 419);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b$a<JSONObject> com_tencent_mm_u_b_b_a_org_json_JSONObject) {
        b Cb = aVar.Cb();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("scope", jSONObject.getString("scope"));
            bundle.putString("appId", Cb.getString("__page_app_id", ""));
            bundle.putString("widgetId", Cb.getString("__page_view_id", ""));
            XIPCInvoker.a(Cb.getString("__process_name", iSW), bundle, b.class, new 1(this));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", new Object[]{e.getMessage()});
        }
    }
}

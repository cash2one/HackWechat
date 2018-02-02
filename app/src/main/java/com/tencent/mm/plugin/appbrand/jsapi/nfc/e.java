package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 353;
    public static final String NAME = "stopHCE";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a(new 1(this, jVar, i));
    }

    static void a(j jVar, int i, String str) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", new Object[]{str});
        if (jVar != null) {
            jVar.E(i, str);
        }
    }
}

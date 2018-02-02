package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class s extends l {
    public static final int CTRL_INDEX = 401;
    public static final String NAME = "canvasToTempFilePathSync";

    public final String a(j jVar, JSONObject jSONObject) {
        p b = b(jVar);
        if (b == null) {
            x.w("MicroMsg.JsApiCanvasToTempFilePathSync", "invoke JsApi insertView failed, current page view is null.");
            return e("fail", null);
        }
        x.i("MicroMsg.JsApiCanvasToTempFilePathSync", "call toTempFilePathForGame.");
        a a = com.tencent.mm.plugin.appbrand.jsapi.c.a.a(b, jSONObject, true);
        return e(a.fnL, a.values);
    }
}

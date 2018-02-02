package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class p extends JsApiUploadWeRunData {
    public static final int CTRL_INDEX = 324;
    public static final String NAME = "addWeRunData";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiAddWeRunData", "JsApiAddWeRunData!");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiAddWeRunData", "data is null");
            return;
        }
        a(this, jVar, i, jSONObject.optInt("step"), true);
    }
}

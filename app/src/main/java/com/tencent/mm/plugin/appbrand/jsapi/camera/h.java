package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ag;
import org.json.JSONObject;

public final class h extends a {
    private static final int CTRL_INDEX = 332;
    public static final String NAME = "operateCamera";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null or nil", null));
        } else {
            ag.y(new 1(this, jSONObject, jVar, i));
        }
    }
}

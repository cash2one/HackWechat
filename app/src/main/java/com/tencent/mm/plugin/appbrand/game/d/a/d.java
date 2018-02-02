package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.ag;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 70;
    private static final String NAME = "hideKeyboard";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        ag.y(new 1(this, jVar));
        jVar.E(i, e("ok", null));
    }
}

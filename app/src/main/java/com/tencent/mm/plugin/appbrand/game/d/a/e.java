package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.sdk.platformtools.ag;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 1;
    private static final String NAME = "showKeyboard";
    final c iZC = new c();
    final a iZD = new a();
    final b iZE = new b();

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("defaultValue");
        int optInt = jSONObject.optInt("maxLength", b.CTRL_INDEX);
        if (optInt <= 0) {
            optInt = Integer.MAX_VALUE;
        }
        ag.y(new 1(this, jVar, optString, optInt, jSONObject.optBoolean("multiple", false), jSONObject.optBoolean("confirmHold", false), com.tencent.mm.plugin.appbrand.widget.input.b.b.uZ(jSONObject.optString("confirmType")), i));
    }
}

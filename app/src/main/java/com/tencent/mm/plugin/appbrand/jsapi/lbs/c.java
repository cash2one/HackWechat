package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 103;
    public static final String NAME = "chooseLocation";
    int jcs = 0;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 8);
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiChooseLocation", "mmActivity is null, invoke fail!");
            return;
        }
        this.jcs = i;
        a.jwN = new 1(this, jVar);
        d.b(a, "location", ".ui.RedirectUI", intent, 1);
    }
}

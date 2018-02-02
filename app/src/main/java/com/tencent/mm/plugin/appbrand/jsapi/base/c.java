package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public abstract class c extends d {
    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        p b = b(jVar);
        if (b == null) {
            x.w("MicroMsg.BaseUpdateViewJsApi", "invoke JsApi updateView failed, current page view is null.");
            jVar.E(i, e("fail:page is null", null));
            return;
        }
        a(jVar, i, b, jSONObject);
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
        a(pVar, i, pVar, jSONObject);
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i, p pVar, JSONObject jSONObject) {
        ag.y(new 1(this, pVar, cVar, i, jSONObject));
    }

    public boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        return true;
    }

    public boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        return true;
    }

    public boolean afL() {
        return false;
    }

    public boolean afN() {
        return false;
    }
}

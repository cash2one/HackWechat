package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.widget.input.b.f;
import org.json.JSONObject;

public final class h extends g {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    protected final /* synthetic */ boolean a(f fVar, JSONObject jSONObject, p pVar, int i) {
        com.tencent.mm.plugin.appbrand.widget.input.b.h hVar = (com.tencent.mm.plugin.appbrand.widget.input.b.h) fVar;
        boolean a = super.a(hVar, jSONObject, pVar, i);
        hVar.kca = Boolean.valueOf(true);
        hVar.kcg = Boolean.valueOf(false);
        Object opt = jSONObject.opt("confirm");
        hVar.kcb = opt == null ? null : g.bl(opt);
        return a;
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
    }
}

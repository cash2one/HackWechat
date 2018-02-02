package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q$g;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 298;
    public static final String NAME = "insertHTMLWebView";

    protected final View a(p pVar, JSONObject jSONObject) {
        if (pVar.ajb() != null) {
            return null;
        }
        View aVar = new a(pVar.mContext, pVar.irP, pVar);
        aVar.setId(q$g.iuz);
        pVar.jDL.add(new 1(this, aVar));
        pVar.a(new 2(this, aVar));
        pVar.a(new 3(this, aVar));
        return aVar;
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
    }
}

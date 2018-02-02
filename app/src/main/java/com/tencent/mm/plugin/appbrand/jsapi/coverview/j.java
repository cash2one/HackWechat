package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class j extends c {
    private static final int CTRL_INDEX = 254;
    public static final String NAME = "updateTextView";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", new Object[]{Integer.valueOf(i), jSONObject});
        if (view instanceof CoverViewContainer) {
            f fVar = (f) ((CoverViewContainer) view).w(f.class);
            if (fVar == null) {
                x.w("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", new Object[]{Integer.valueOf(i)});
            }
            a.a(fVar, jSONObject.optJSONObject("label"));
            d.a(view, jSONObject.optJSONObject("style"));
            return super.c(pVar, i, view, jSONObject);
        }
        x.w("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}

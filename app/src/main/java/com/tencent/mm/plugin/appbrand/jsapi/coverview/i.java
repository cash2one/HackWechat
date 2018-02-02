package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends c {
    private static final int CTRL_INDEX = 447;
    public static final String NAME = "updateScrollView";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", new Object[]{Integer.valueOf(i), jSONObject});
        if (view instanceof WxaScrollView) {
            WxaScrollView wxaScrollView = (WxaScrollView) view;
            d.a(view, jSONObject.optJSONObject("style"));
            try {
                if (jSONObject.getBoolean("needScrollEvent")) {
                    wxaScrollView.jjo = new 1(this, pVar, i);
                } else {
                    wxaScrollView.jjo = null;
                }
            } catch (JSONException e) {
            }
            return super.c(pVar, i, view, jSONObject);
        }
        x.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", new Object[]{Integer.valueOf(i)});
        return false;
    }
}

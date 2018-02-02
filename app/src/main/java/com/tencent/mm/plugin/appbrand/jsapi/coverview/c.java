package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 446;
    public static final String NAME = "insertScrollView";

    protected final View a(p pVar, JSONObject jSONObject) {
        return new WxaScrollView(pVar.mContext);
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertScrollView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        WxaScrollView wxaScrollView = (WxaScrollView) view;
        boolean optBoolean = jSONObject.optBoolean("needScrollEvent");
        String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, "");
        d.a(view, jSONObject.optJSONObject("style"));
        pVar.aeF().y(i, true).o(SlookAirButtonFrequentContactAdapter.DATA, optString);
        if (optBoolean) {
            wxaScrollView.jjo = new 1(this, pVar, i);
        }
    }
}

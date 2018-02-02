package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        return new CoverViewContainer(context, new f(context));
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        f fVar = (f) ((CoverViewContainer) view).w(f.class);
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, "");
        com.tencent.mm.plugin.appbrand.jsapi.m.a.a(fVar, jSONObject.optJSONObject("label"));
        com.tencent.mm.plugin.appbrand.jsapi.m.d.a(view, jSONObject.optJSONObject("style"));
        b y = pVar.aeF().y(i, true);
        y.o(SlookAirButtonFrequentContactAdapter.DATA, optString2);
        y.o("sendTo", optString);
        y.o("transEvt", Boolean.valueOf(optBoolean2));
        y.o("clickable", Boolean.valueOf(optBoolean));
        fVar.setOnClickListener(new 1(this, y, pVar));
        fVar.setClickable(optBoolean);
    }
}

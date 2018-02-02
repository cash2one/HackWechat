package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        View bVar = new com.tencent.mm.plugin.appbrand.widget.b(context);
        bVar.setScaleType(ScaleType.FIT_XY);
        return new CoverViewContainer(context, bVar);
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        com.tencent.mm.plugin.appbrand.widget.b bVar = (com.tencent.mm.plugin.appbrand.widget.b) ((CoverViewContainer) view).w(com.tencent.mm.plugin.appbrand.widget.b.class);
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, "");
        d.a(view, jSONObject.optJSONObject("style"));
        com.tencent.mm.plugin.appbrand.jsapi.m.a.a(pVar, bVar, jSONObject);
        com.tencent.mm.z.u.b y = pVar.aeF().y(i, true);
        y.o(SlookAirButtonFrequentContactAdapter.DATA, optString2);
        y.o("sendTo", optString);
        y.o("transEvt", Boolean.valueOf(optBoolean2));
        y.o("clickable", Boolean.valueOf(optBoolean));
        bVar.setOnClickListener(new 1(this, y, pVar));
        bVar.setClickable(optBoolean);
    }
}

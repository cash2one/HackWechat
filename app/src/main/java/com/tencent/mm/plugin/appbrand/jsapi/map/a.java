package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Color;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b$b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends c {
    public static final int CTRL_INDEX = 135;
    public static final String NAME = "addMapCircles";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapCircles", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.i("MicroMsg.JsApiAddMapCircles", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                com.tencent.mm.plugin.appbrand.compat.a.b bE = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
                if (bE == null) {
                    x.w("MicroMsg.JsApiAddMapCircles", "MapView(%s) is null", new Object[]{Integer.valueOf(i)});
                    return false;
                }
                try {
                    if (jSONObject.has("circles")) {
                        List list;
                        int i2;
                        List list2 = (List) y.get("map_circle", null);
                        if (list2 == null) {
                            ArrayList arrayList = new ArrayList();
                            y.o("map_circle", arrayList);
                            list = arrayList;
                        } else {
                            list = list2;
                        }
                        if (list.size() > 0) {
                            for (i2 = 0; i2 < list.size(); i2++) {
                                ((b$b) list.get(i2)).remove();
                            }
                            list.clear();
                        }
                        JSONArray jSONArray = new JSONArray(jSONObject.optString("circles"));
                        for (i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                            float f = bh.getFloat(jSONObject2.optString("latitude"), 0.0f);
                            float f2 = bh.getFloat(jSONObject2.optString("longitude"), 0.0f);
                            int aP = f.aP(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                            int aP2 = f.aP(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                            int optInt = jSONObject2.optInt("radius");
                            float a = f.a(jSONObject2, "strokeWidth", 0.0f);
                            com.tencent.mm.plugin.appbrand.compat.a.b.c abx = bE.abx();
                            abx.d((double) f, (double) f2);
                            abx.jI(optInt);
                            abx.jJ(aP);
                            abx.jK((int) a);
                            abx.jL(aP2);
                            list.add(bE.a(abx));
                        }
                    }
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", new Object[]{e});
                    return false;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.JsApiAddMapCircles", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiAddMapCircles", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }
}

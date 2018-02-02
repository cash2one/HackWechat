package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends c {
    public static final int CTRL_INDEX = 136;
    public static final String NAME = "includeMapPoints";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiIncludeMapPoints", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (pVar.aeF().y(i, false) == null) {
            x.i("MicroMsg.JsApiIncludeMapPoints", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                b bE = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
                x.i("MicroMsg.JsApiIncludeMapPoints", "includeMapPoints, onUpdateView()");
                try {
                    if (jSONObject.has("points")) {
                        List arrayList = new ArrayList();
                        String optString = jSONObject.optString("points");
                        if (!bh.ov(optString)) {
                            JSONArray jSONArray = new JSONArray(optString);
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                                arrayList.add(bE.e((double) bh.getFloat(jSONObject2.optString("latitude"), 0.0f), (double) bh.getFloat(jSONObject2.optString("longitude"), 0.0f)));
                            }
                        }
                        int i3 = 0;
                        String optString2 = jSONObject.optString("padding");
                        if (!bh.ov(optString2)) {
                            i3 = f.a(new JSONArray(optString2), 0);
                        }
                        if (arrayList.size() > 0) {
                            bE.c(arrayList, i3);
                        }
                    }
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", new Object[]{e});
                    return false;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.JsApiIncludeMapPoints", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e2});
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiIncludeMapPoints", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }
}

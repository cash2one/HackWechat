package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 144;
    public static final String NAME = "getMapCenterLocation";

    private static int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiGetMapCenterLocation", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        p b = b(jVar);
        if (b == null) {
            x.e("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation pv is null");
            return;
        }
        x.i("MicroMsg.JsApiGetMapCenterLocation", "getMapCenterLocation data:%s", new Object[]{jSONObject.toString()});
        try {
            View lo = b.aeF().lo(i(jSONObject));
            if (lo instanceof CoverViewContainer) {
                b bE = ((c) g.h(c.class)).bE(((CoverViewContainer) lo).w(View.class));
                Map hashMap = new HashMap();
                if (bE != null) {
                    f abu = bE.abu();
                    hashMap.put("latitude", Double.valueOf(abu.abC()));
                    hashMap.put("longitude", Double.valueOf(abu.abD()));
                    x.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", new Object[]{hashMap.toString()});
                    jVar.E(i, e("ok", hashMap));
                    return;
                }
                x.e("MicroMsg.JsApiGetMapCenterLocation", "get SoSoMapView by id failed");
                jVar.E(i, e("fail", null));
                return;
            }
            x.w("MicroMsg.JsApiGetMapCenterLocation", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(r2)});
            jVar.E(i, e("fail:the view is not a instance of CoverViewContainer", null));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiGetMapCenterLocation", e, "get SoSoMapView by id failed, exception", new Object[0]);
            jVar.E(i, e("fail", null));
        }
    }
}

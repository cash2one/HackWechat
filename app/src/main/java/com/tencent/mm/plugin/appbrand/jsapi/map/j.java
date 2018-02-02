package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import org.json.JSONObject;

public final class j extends c {
    public static final int CTRL_INDEX = 141;
    public static final String NAME = "moveToMapLocation";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiMoveToMapLocation", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.i("MicroMsg.JsApiMoveToMapLocation", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                com.tencent.mm.plugin.appbrand.compat.a.b bE = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
                AppbrandMapLocationPoint appbrandMapLocationPoint = (AppbrandMapLocationPoint) y.get(String.valueOf(i), null);
                if (appbrandMapLocationPoint != null) {
                    bE.animateTo(appbrandMapLocationPoint.jlP, appbrandMapLocationPoint.jlQ);
                    return true;
                }
                x.e("MicroMsg.JsApiMoveToMapLocation", "appbrandMapLocationPoint is null");
                return false;
            } catch (Exception e) {
                x.e("MicroMsg.JsApiMoveToMapLocation", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e});
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiMoveToMapLocation", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
            return false;
        }
    }
}

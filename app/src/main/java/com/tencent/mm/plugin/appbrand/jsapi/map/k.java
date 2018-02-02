package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import java.util.List;
import org.json.JSONObject;

public final class k extends b {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRemoveMap", "get mapId error, exception : %s", e);
        }
        return i;
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        super.b(pVar, i, view, jSONObject);
        u.b lp = pVar.aeF().lp(i);
        if (lp == null) {
            x.i("MicroMsg.JsApiRemoveMap", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                com.tencent.mm.plugin.appbrand.compat.a.b bE = ((c) g.h(c.class)).bE(((CoverViewContainer) view).w(View.class));
                List list = (List) lp.get("markers", null);
                List list2 = (List) lp.get("converters", null);
                if (list != null && list.size() > 0) {
                    list.clear();
                }
                if (list2 != null && list2.size() > 0) {
                    list2.clear();
                }
                ag.y(new 1(this, bE));
                lp.recycle();
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.JsApiRemoveMap", "get SoSoMapView(%s) by id failed, exception : %s", Integer.valueOf(i), e);
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiRemoveMap", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends c {
    public static final int CTRL_INDEX = 343;
    public static final String NAME = "removeMapMarkers";

    protected final int i(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRemoveMapMarkers", "get mapId error, exception : %s", e);
        }
        return i;
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        b y = pVar.aeF().y(i, false);
        if (y == null) {
            x.e("MicroMsg.JsApiRemoveMapMarkers", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            return false;
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiRemoveMapMarkers", "data is null");
            return false;
        } else {
            x.i("MicroMsg.JsApiRemoveMapMarkers", "removeMapMarkers, data:%s", jSONObject.toString());
            if (jSONObject.has("markers")) {
                Map map = (Map) y.get("marker", null);
                if (map == null || map.size() < 0) {
                    x.e("MicroMsg.JsApiRemoveMapMarkers", "markerMap is empty!");
                    return false;
                }
                try {
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        h hVar = (h) map.get(string);
                        if (hVar == null) {
                            x.e("MicroMsg.JsApiRemoveMapMarkers", "marker id:[%s], isn't exist", string);
                        } else {
                            map.remove(string);
                            hVar.remove();
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiRemoveMapMarkers", e, "", new Object[0]);
                    return false;
                }
            }
            return true;
        }
    }
}

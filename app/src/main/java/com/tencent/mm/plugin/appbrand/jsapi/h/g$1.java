package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.plugin.appbrand.widget.picker.e;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

class g$1 extends c {
    final /* synthetic */ g jpA;

    g$1(g gVar) {
        this.jpA = gVar;
    }

    static /* synthetic */ e a(g$1 com_tencent_mm_plugin_appbrand_jsapi_h_g_1, Class cls) {
        d dz = super.dz(false);
        return (dz == null || !cls.isInstance(dz.kdn)) ? null : dz.kdn;
    }

    final void r(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("column", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
            f("fail:invalid data", null);
            return;
        }
        try {
            String[] strArr = new String[optJSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = optJSONArray.getString(i);
            }
            c.runOnUiThread(new 1(this, optInt, new a(strArr, jSONObject.optInt("current", 0))));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e, "opt params", new Object[0]);
            f("fail:invalid data", null);
        }
    }
}

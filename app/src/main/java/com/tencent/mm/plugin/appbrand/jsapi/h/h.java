package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

final class h extends c {
    h() {
    }

    final void r(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            f("fail:invalid data", null);
            return;
        }
        String[] strArr = new String[optJSONArray.length()];
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                strArr[i] = optJSONArray.getString(i);
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[]{bh.i(e)});
                f("fail", null);
                return;
            }
        }
        c.runOnUiThread(new 1(this, strArr, optInt));
    }
}

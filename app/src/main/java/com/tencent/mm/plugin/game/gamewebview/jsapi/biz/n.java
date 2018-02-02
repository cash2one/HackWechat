package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends a {
    public static final int CTRL_BYTE = 188;
    public static final String NAME = "disableBounceScroll";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        x.i("MicroMsg.GameJsApiDisableBounceScroll", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("place");
        if (optJSONArray == null) {
            x.i("MicroMsg.GameJsApiDisableBounceScroll", "placeArray is null");
            dVar.E(i, a.e("disableBounceScroll:fail", null));
            return;
        }
        int i3 = 0;
        while (i2 < optJSONArray.length()) {
            if ("top".equalsIgnoreCase(optJSONArray.optString(i2))) {
                i3 = 1;
            }
            i2++;
        }
        if (i3 == 0) {
            dVar.E(i, a.e("disableBounceScroll:ok", null));
            return;
        }
        dVar.mHandler.post(new d$24(dVar));
        dVar.E(i, a.e("disableBounceScroll:ok", null));
    }
}

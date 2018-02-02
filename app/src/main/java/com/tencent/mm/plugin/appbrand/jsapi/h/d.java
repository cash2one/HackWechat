package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 84;
    public static final String NAME = "showDatePickerView";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
        String optString = jSONObject.optString("mode");
        if (FFmpegMetadataRetriever.METADATA_KEY_DATE.equals(optString)) {
            new a().a(this, pVar, jSONObject, i);
        } else if ("time".equals(optString)) {
            new i().a(this, pVar, jSONObject, i);
        } else {
            pVar.E(i, e("fail:invalid data", null));
        }
    }
}

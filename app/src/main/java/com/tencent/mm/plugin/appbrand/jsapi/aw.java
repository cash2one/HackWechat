package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class aw extends a {
    private static final int CTRL_INDEX = 170;
    private static final String NAME = "reLaunch";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        jVar.irP.iqC.W(jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL), false);
        jVar.E(i, e("ok", null));
    }
}

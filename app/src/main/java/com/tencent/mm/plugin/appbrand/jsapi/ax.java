package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class ax extends a {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (jVar.irP.iqy.iMA.qA(optString)) {
            jVar.E(i, e("fail:can not redirect to a tab bar page", null));
            return;
        }
        jVar.irP.iqC.tE(optString);
        jVar.E(i, e("ok", null));
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class bm extends a {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (jVar.irP.iqy.iMA.qA(optString)) {
            jVar.irP.iqC.tF(optString);
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail:can not switch to non-TabBar page", null));
    }
}

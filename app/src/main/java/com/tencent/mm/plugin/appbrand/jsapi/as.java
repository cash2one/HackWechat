package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class as extends a {
    public static final int CTRL_INDEX = 201;
    public static final String NAME = "openUrl";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        Intent putExtra = new Intent().putExtra("rawUrl", optString).putExtra("appbrand_report_key_target_url", optString);
        if (jVar.getContext() != null) {
            d.b(jVar.getContext(), "webview", ".ui.tools.WebViewUI", putExtra);
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail", null));
    }
}

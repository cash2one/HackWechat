package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

final class ao extends a {
    public static final int CTRL_INDEX = 0;
    public static final String NAME = "openLink";

    ao() {
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString)) {
            pVar.E(i, e("fail", null));
            return;
        }
        Intent putExtra = new Intent().putExtra("rawUrl", optString).putExtra("appbrand_report_key_target_url", optString);
        putExtra.putExtra("rawUrl", optString);
        d.b(pVar.mContext, "webview", ".ui.tools.WebViewUI", putExtra);
        pVar.E(i, e("ok", null));
    }
}

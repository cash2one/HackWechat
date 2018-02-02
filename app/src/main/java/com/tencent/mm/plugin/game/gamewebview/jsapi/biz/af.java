package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class af extends a {
    public static final int CTRL_BYTE = 173;
    public static final String NAME = "openUrlWithExtraWebview";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        GameWebViewUI aPh = dVar.aPh();
        if (aPh == null) {
            x.i("MicroMsg.GameJsApiOpenUrlWithExtraWebView", "activity is null");
            return;
        }
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString)) {
            dVar.E(i, a.e("openUrlWithExtraWebview:fail_invalid_url", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", optString);
        x.d("MicroMsg.GameJsApiOpenUrlWithExtraWebView", "openUrlWithExtraWebview: " + System.currentTimeMillis());
        aPh.K(intent);
        dVar.E(i, a.e("openUrlWithExtraWebview:ok", null));
    }
}

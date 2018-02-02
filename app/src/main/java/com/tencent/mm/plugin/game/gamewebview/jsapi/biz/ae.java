package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import android.graphics.Color;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ae extends a {
    public static final int CTRL_BYTE = -2;
    public static final String NAME = "openGameUrlWithExtraWebView";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiOpenGameUrlWithExtraWebView", "invoke");
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(optString)) {
            x.e("MicroMsg.GameJsApiOpenGameUrlWithExtraWebView", "url is null");
            dVar.E(i, a.e("openGameUrlWithExtraWebView:fail", null));
            return;
        }
        String optString2 = jSONObject.optString("statusBarColor");
        int i2 = 0;
        if (!bh.ov(optString2)) {
            try {
                i2 = Color.parseColor(optString2);
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.GameJsApiOpenGameUrlWithExtraWebView", e.getMessage());
                dVar.E(i, a.e("openGameUrlWithExtraWebView:fail_invalid_color", null));
                return;
            }
        }
        optString2 = jSONObject.optString("statusBarStyle");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", optString);
        intent.putExtra("customize_status_bar_color", i2);
        intent.putExtra("status_bar_style", optString2);
        dVar.aPh().K(intent);
        dVar.E(i, "openGameUrlWithExtraWebView:ok");
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class an extends a {
    public static final int CTRL_INDEX = 247;
    public static final String NAME = "openDeliveryList";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("query");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://mp.weixin.qq.com/bizmall/expressentry" + optString);
        intent.putExtra("show_native_web_view", true);
        intent.putExtra("KRightBtn", true);
        if (jVar.getContext() != null) {
            d.b(jVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail", null));
    }
}

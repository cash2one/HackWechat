package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.52;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class AppBrandSearchUI$2 implements Runnable {
    final /* synthetic */ AppBrandSearchUI jLP;
    final /* synthetic */ String jLQ;
    final /* synthetic */ int jLR;
    final /* synthetic */ int jLS;

    AppBrandSearchUI$2(AppBrandSearchUI appBrandSearchUI, String str, int i, int i2) {
        this.jLP = appBrandSearchUI;
        this.jLQ = str;
        this.jLR = i;
        this.jLS = i2;
    }

    public final void run() {
        if (AppBrandSearchUI.b(this.jLP) != null) {
            d c = AppBrandSearchUI.c(this.jLP);
            String str = this.jLQ;
            int i = this.jLR;
            int i2 = this.jLS;
            if (c.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
                Map hashMap = new HashMap();
                hashMap.put("json", str);
                hashMap.put("isCacheData", Integer.valueOf(i));
                hashMap.put("isExpired", Integer.valueOf(i2));
                ag.y(new 52(c, a.a("onSearchGuideDataReady", hashMap, c.tGS, c.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
        }
    }
}

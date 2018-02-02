package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.19;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$12$6 implements Runnable {
    final /* synthetic */ int fmb;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$6(12 12, int i) {
        this.tAx = 12;
        this.fmb = i;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            d dVar = this.tAx.tAv.tlx;
            int i = this.fmb;
            if (dVar.tGQ) {
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                ag.y(new 19(dVar, a.a("onNfcTouch", hashMap, dVar.tGS, dVar.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
        }
    }
}

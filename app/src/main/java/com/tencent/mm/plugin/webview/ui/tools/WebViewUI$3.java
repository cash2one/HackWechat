package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.f.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.54;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$3 implements a {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$3(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void bSw() {
        x.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
        if (this.tAv.tlx != null) {
            d dVar = this.tAv.tlx;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
                ag.y(new 54(dVar, d.PE(i$a.a("onPullDownRefresh", null, dVar.tGS, dVar.tGT))));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
        }
    }
}

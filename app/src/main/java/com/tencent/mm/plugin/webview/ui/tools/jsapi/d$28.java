package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$28 implements Runnable {
    final /* synthetic */ d tHd;
    final /* synthetic */ String tHf;

    d$28(d dVar, String str) {
        this.tHd = dVar;
        this.tHf = str;
    }

    public final void run() {
        try {
            d.d(this.tHd).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.tHf + ")", null);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", new Object[]{e.getMessage()});
        }
    }
}

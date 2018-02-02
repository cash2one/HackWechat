package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$46 implements Runnable {
    final /* synthetic */ String iXg;
    final /* synthetic */ d tHd;
    final /* synthetic */ String tHg;

    d$46(d dVar, String str, String str2) {
        this.tHd = dVar;
        this.tHg = str;
        this.iXg = str2;
    }

    public final void run() {
        try {
            d.d(this.tHd).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.tHg + ")", null);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[]{this.iXg, e.getMessage()});
        }
    }
}

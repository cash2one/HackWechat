package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$14 implements Runnable {
    final /* synthetic */ String iXg;
    final /* synthetic */ d tHd;

    d$14(d dVar, String str) {
        this.tHd = dVar;
        this.iXg = str;
    }

    public final void run() {
        try {
            d.d(this.tHd).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.iXg + ")", null);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", new Object[]{e.getMessage()});
        }
    }
}

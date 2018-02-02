package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class d$54 implements Runnable {
    final /* synthetic */ d tHd;
    final /* synthetic */ String tHh;

    public d$54(d dVar, String str) {
        this.tHd = dVar;
        this.tHh = str;
    }

    public final void run() {
        try {
            d.d(this.tHd).evaluateJavascript(this.tHh, null);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", new Object[]{e.getMessage()});
        }
    }
}

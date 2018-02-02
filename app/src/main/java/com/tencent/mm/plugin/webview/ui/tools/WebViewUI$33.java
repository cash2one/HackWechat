package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class WebViewUI$33 implements c {
    final /* synthetic */ WebViewUI tAv;
    final /* synthetic */ String val$url;

    WebViewUI$33(WebViewUI webViewUI, String str) {
        this.tAv = webViewUI;
        this.val$url = str;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                if (WebViewUI.g(this.tAv, this.val$url)) {
                    this.tAv.ptK.loadUrl(this.val$url);
                    return;
                }
                x.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + this.val$url);
                WebViewUI.V(this.tAv);
                return;
            case 1:
                com.tencent.mm.pluginsdk.h.c.a(this.tAv, this.val$url, this.val$url);
                return;
            default:
                return;
        }
    }
}

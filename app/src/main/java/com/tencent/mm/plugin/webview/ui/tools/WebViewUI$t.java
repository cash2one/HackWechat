package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.model.y.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$t implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$t(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        d dVar = this.tAv.juQ;
        if (6 != this.tAv.getIntent().getIntExtra("geta8key_scene", 0)) {
            return !bh.ov(str) && dVar != null && c.a(dVar) && c.a(str, dVar);
        } else {
            x.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
            return false;
        }
    }

    public final boolean BU(String str) {
        String stringExtra = this.tAv.getIntent().getStringExtra("geta8key_username");
        return c.a(str, stringExtra, WebViewUI.b(this.tAv, stringExtra), this.tAv.juQ, WebViewUI.aN(this.tAv), WebViewUI.b(this.tAv), this.tAv.hashCode());
    }
}

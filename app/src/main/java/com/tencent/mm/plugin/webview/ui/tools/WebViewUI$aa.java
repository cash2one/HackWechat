package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$aa implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$aa(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://viewimage/");
    }

    public final boolean BU(String str) {
        try {
            if (this.tAv.juQ.isSDCardAvailable()) {
                WebViewUI.s(this.tAv, str.substring(19));
                x.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + WebViewUI.aO(this.tAv));
                s.a(this.tAv.ptK, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", WebViewUI.aP(this.tAv));
                return true;
            }
            this.tAv.juQ.a(2, null, this.tAv.hashCode());
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + e.getMessage());
            return false;
        }
    }
}

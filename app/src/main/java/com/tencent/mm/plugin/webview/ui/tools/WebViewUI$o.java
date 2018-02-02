package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$o implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$o(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://gethtml/");
    }

    public final boolean BU(String str) {
        if (!bh.ov(str)) {
            x.i("MicroMsg.WebViewUI", "[oneliang]get html content :" + str.substring(17));
            this.tAv.bST();
        }
        return false;
    }
}

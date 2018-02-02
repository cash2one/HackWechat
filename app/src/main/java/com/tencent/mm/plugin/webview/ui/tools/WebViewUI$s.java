package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;

class WebViewUI$s implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$s(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://manual_update/");
    }

    public final boolean BU(String str) {
        g.pQN.a(405, 26, 1, true);
        WebViewUI.g(this.tAv, 3);
        return true;
    }
}

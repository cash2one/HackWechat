package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.h.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;

class WebViewUI$e implements b {
    final /* synthetic */ WebViewUI tAv;
    private final String tBv;

    private WebViewUI$e(WebViewUI webViewUI) {
        this.tAv = webViewUI;
        this.tBv = "weixin://webview/copy/";
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://webview/copy/");
    }

    public final boolean BU(String str) {
        CharSequence substring = str.substring(22);
        c.a(this.tAv, substring, substring);
        return true;
    }
}

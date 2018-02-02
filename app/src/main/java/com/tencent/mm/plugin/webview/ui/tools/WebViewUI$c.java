package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$c implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$c(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://webview/close/");
    }

    public final boolean BU(String str) {
        if (this.tAv.juR.bSs().gn(17)) {
            this.tAv.finish();
        } else {
            x.e("MicroMsg.WebViewUI", "close window permission fail");
        }
        return true;
    }
}

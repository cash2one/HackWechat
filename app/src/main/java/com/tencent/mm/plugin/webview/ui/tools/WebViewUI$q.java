package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$q implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$q(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://profile/");
    }

    public final boolean BU(String str) {
        String substring = str.substring(17);
        if (substring == null || substring.length() == 0) {
            x.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
        } else if (!(this.tAv.juR == null || this.tAv.juR.bSs() == null || !this.tAv.juR.bSs().gn(2))) {
            this.tAv.tlx.PC(substring);
        }
        return true;
    }
}

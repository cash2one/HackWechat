package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$a implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$a(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://jump/");
    }

    public final boolean BU(String str) {
        if (this.tAv.juR.bSt().cdA()) {
            try {
                this.tAv.juQ.aP(str, this.tAv.juR.bSs().gn(7));
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + e.getMessage());
            }
        } else {
            x.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", str);
        }
        return true;
    }
}

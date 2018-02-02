package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.29;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$29$1 implements b {
    final /* synthetic */ 29 tBk;

    WebViewUI$29$1(29 29) {
        this.tBk = 29;
    }

    public final void sS(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.WebViewUI", "share image to friend fail, imgPath is null");
        } else {
            WebViewUI.e(this.tBk.tAv, str);
        }
    }
}

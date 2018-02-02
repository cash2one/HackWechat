package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$46 implements Runnable {
    final /* synthetic */ 12 tAx;

    WebViewUI$12$46(12 12) {
        this.tAx = 12;
    }

    public final void run() {
        if (WebViewUI.t(this.tAx.tAv) != null && WebViewUI.t(this.tAx.tAv).isShowing()) {
            WebViewUI.t(this.tAx.tAv).dismiss();
        }
    }
}

package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$51 implements Runnable {
    final /* synthetic */ 12 tAx;
    final /* synthetic */ int tBb;
    final /* synthetic */ String tBc;

    WebViewUI$12$51(12 12, String str, int i) {
        this.tAx = 12;
        this.tBc = str;
        this.tBb = i;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            this.tAx.tAv.tlx.cD(this.tBc, this.tBb);
        }
    }
}

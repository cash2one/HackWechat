package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$3 implements Runnable {
    final /* synthetic */ int ikE;
    final /* synthetic */ 12 tAx;
    final /* synthetic */ String tAy;

    WebViewUI$12$3(12 12, String str, int i) {
        this.tAx = 12;
        this.tAy = str;
        this.ikE = i;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            this.tAx.tAv.tlx.cG(this.tAy, this.ikE);
        }
    }
}

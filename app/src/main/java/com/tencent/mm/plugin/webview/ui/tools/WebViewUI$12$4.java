package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;

class WebViewUI$12$4 implements Runnable {
    final /* synthetic */ int ikE;
    final /* synthetic */ String jjz;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$4(12 12, String str, int i) {
        this.tAx = 12;
        this.jjz = str;
        this.ikE = i;
    }

    public final void run() {
        if (this.tAx.tAv.tlx != null) {
            this.tAx.tAv.tlx.cH(this.jjz, this.ikE);
        }
    }
}

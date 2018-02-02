package com.tencent.mm.plugin.webview.ui.tools;

class WebViewUI$44 implements Runnable {
    final /* synthetic */ int jXy;
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$44(WebViewUI webViewUI, int i) {
        this.tAv = webViewUI;
        this.jXy = i;
    }

    public final void run() {
        if (this.tAv.tlx != null) {
            this.tAv.tlx.AZ(this.jXy);
        }
    }
}

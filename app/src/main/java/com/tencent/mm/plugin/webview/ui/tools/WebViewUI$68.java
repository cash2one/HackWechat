package com.tencent.mm.plugin.webview.ui.tools;

class WebViewUI$68 implements Runnable {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$68(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void run() {
        if (this.tAv.tyo != null) {
            this.tAv.tyo.finish();
        }
    }
}

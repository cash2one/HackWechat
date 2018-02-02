package com.tencent.mm.plugin.webview.ui.tools;

class WebViewUI$26 implements Runnable {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$26(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void run() {
        this.tAv.ptK.getCurWebviewClient().a(this.tAv.ptK, this.tAv.ptK.getUrl());
    }
}

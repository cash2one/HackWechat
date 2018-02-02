package com.tencent.smtt.sdk;

public class WebView$WebViewTransport {
    private WebView mWebview;
    final /* synthetic */ WebView this$0;

    public WebView$WebViewTransport(WebView webView) {
        this.this$0 = webView;
    }

    public synchronized WebView getWebView() {
        return this.mWebview;
    }

    public synchronized void setWebView(WebView webView) {
        this.mWebview = webView;
    }
}

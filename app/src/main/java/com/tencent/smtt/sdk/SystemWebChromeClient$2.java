package com.tencent.smtt.sdk;

import android.os.Message;
import android.webkit.WebView;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class SystemWebChromeClient$2 implements Runnable {
    final /* synthetic */ SystemWebChromeClient this$0;
    final /* synthetic */ Message val$resultMsg;
    final /* synthetic */ WebViewTransport val$transport;

    SystemWebChromeClient$2(SystemWebChromeClient systemWebChromeClient, WebViewTransport webViewTransport, Message message) {
        this.this$0 = systemWebChromeClient;
        this.val$transport = webViewTransport;
        this.val$resultMsg = message;
    }

    public void run() {
        WebView webView = this.val$transport.getWebView();
        if (webView != null) {
            ((WebView.WebViewTransport) this.val$resultMsg.obj).setWebView(!webView.zZk ? webView.zZm : null);
        }
        this.val$resultMsg.sendToTarget();
    }
}

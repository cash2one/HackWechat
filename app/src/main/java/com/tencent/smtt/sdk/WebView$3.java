package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;

class WebView$3 implements FindListener {
    final /* synthetic */ WebView this$0;
    final /* synthetic */ IX5WebViewBase.FindListener val$listener;

    WebView$3(WebView webView, IX5WebViewBase.FindListener findListener) {
        this.this$0 = webView;
        this.val$listener = findListener;
    }

    public void onFindResultReceived(int i, int i2, boolean z) {
        this.val$listener.onFindResultReceived(i, i2, z);
    }
}

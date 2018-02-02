package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class c extends WebViewClient {
    public final void a(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }
}

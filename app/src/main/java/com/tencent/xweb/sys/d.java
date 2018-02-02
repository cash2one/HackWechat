package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.xweb.c.e;
import com.tencent.xweb.f;

public final class d implements e {
    WebViewClient Arh = new WebViewClient();
    WebChromeClient Ari = new WebChromeClient();
    WebView Arj;

    public d(WebView webView) {
        this.Arj = webView;
    }

    public final void x(String str, Bitmap bitmap) {
        this.Arh.onPageStarted(this.Arj, str, bitmap);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
    }

    public final boolean a(String str, String str2, f fVar) {
        return false;
    }

    public final boolean b(String str, String str2, f fVar) {
        return false;
    }

    public final boolean a(String str, String str2, String str3, com.tencent.xweb.e eVar) {
        return false;
    }
}

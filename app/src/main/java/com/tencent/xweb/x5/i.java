package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.c.e;
import com.tencent.xweb.f;

public final class i implements e {
    c ArW = new c();
    b ArX = new b();
    WebView zVo;

    public i(WebView webView) {
        this.zVo = webView;
    }

    public final void x(String str, Bitmap bitmap) {
        this.ArW.a(this.zVo, str, bitmap);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
        this.ArX.cIT();
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

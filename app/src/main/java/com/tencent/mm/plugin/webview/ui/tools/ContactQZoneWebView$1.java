package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class ContactQZoneWebView$1 extends p {
    final /* synthetic */ ContactQZoneWebView twb;

    ContactQZoneWebView$1(ContactQZoneWebView contactQZoneWebView) {
        this.twb = contactQZoneWebView;
    }

    public final boolean b(WebView webView, String str) {
        if (str.startsWith("weixin://viewimage/")) {
            this.twb.OY(str);
            webView.stopLoading();
        } else if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
            webView.loadUrl(str);
        }
        return true;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        if (str.startsWith("weixin://viewimage/")) {
            this.twb.OY(str);
            webView.stopLoading();
        } else if (str.equals(ContactQZoneWebView.a(this.twb))) {
            bh.F(this.twb, str);
            webView.stopLoading();
        } else {
            super.b(webView, str, bitmap);
        }
    }
}

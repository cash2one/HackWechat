package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.Log;

public final class d implements a {
    CookieManager ArI = CookieManager.getInstance();

    public final void setAcceptCookie(boolean z) {
        this.ArI.setAcceptCookie(true);
    }

    public final void a(WebView webView, boolean z) {
        if (webView == null) {
            Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
            return;
        }
        View webViewUI = webView.getWebViewUI();
        if (webViewUI instanceof com.tencent.smtt.sdk.WebView) {
            this.ArI.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView) webViewUI, true);
        } else {
            Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
        }
    }

    public final void removeAllCookie() {
        this.ArI.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.ArI.getCookie(str);
    }

    public final void setCookie(String str, String str2) {
        this.ArI.setCookie(str, str2);
    }

    public final void removeSessionCookie() {
        this.ArI.removeSessionCookie();
    }
}

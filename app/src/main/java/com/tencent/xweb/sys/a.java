package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.xweb.WebView;
import org.xwalk.core.Log;

public final class a implements com.tencent.xweb.c.b.a {
    CookieManager Ara = CookieManager.getInstance();

    public final void setAcceptCookie(boolean z) {
        this.Ara.setAcceptCookie(true);
    }

    public final void a(WebView webView, boolean z) {
        if (VERSION.SDK_INT < 21) {
            return;
        }
        if (webView == null || webView.getWebViewUI() == null || !(webView.getWebViewUI() instanceof android.webkit.WebView)) {
            Log.e("SysCookieManagerWrapper", "webview kind not match");
        } else {
            this.Ara.setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewUI(), true);
        }
    }

    public final void removeAllCookie() {
        this.Ara.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.Ara.getCookie(str);
    }

    public final void setCookie(String str, String str2) {
        this.Ara.setCookie(str, str2);
    }

    public final void removeSessionCookie() {
        this.Ara.removeSessionCookie();
    }
}

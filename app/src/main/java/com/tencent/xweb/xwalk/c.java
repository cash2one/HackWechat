package com.tencent.xweb.xwalk;

import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.XWalkCookieManager;

public final class c implements a {
    XWalkCookieManager AsU = new XWalkCookieManager();

    public final void setAcceptCookie(boolean z) {
        this.AsU.setAcceptCookie(true);
    }

    public final void a(WebView webView, boolean z) {
    }

    public final void removeAllCookie() {
        this.AsU.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.AsU.getCookie(str);
    }

    public final void setCookie(String str, String str2) {
        this.AsU.setCookie(str, str2);
    }

    public final void removeSessionCookie() {
        this.AsU.removeSessionCookie();
    }
}

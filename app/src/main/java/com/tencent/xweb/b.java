package com.tencent.xweb;

import com.tencent.xweb.c.b.a;

public final class b {
    private static b ApK;
    public a ApL;

    private b() {
    }

    public static synchronized b cIj() {
        b bVar;
        synchronized (b.class) {
            if (ApK == null) {
                ApK = new b();
            }
            bVar = ApK;
        }
        return bVar;
    }

    public final void removeAllCookie() {
        this.ApL.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.ApL.getCookie(str);
    }

    public final synchronized void setCookie(String str, String str2) {
        this.ApL.setCookie(str, str2);
    }

    public final synchronized void cIk() {
        if (this.ApL != null) {
            this.ApL.setAcceptCookie(true);
        }
    }

    public final synchronized void b(WebView webView) {
        if (this.ApL != null) {
            this.ApL.a(webView, true);
        }
    }
}

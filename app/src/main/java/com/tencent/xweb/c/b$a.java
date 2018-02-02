package com.tencent.xweb.c;

import com.tencent.xweb.WebView;

public interface b$a {
    void a(WebView webView, boolean z);

    String getCookie(String str);

    void removeAllCookie();

    void removeSessionCookie();

    void setAcceptCookie(boolean z);

    void setCookie(String str, String str2);
}

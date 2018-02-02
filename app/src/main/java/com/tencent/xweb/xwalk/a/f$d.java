package com.tencent.xweb.xwalk.a;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

class f$d {
    private static TrustManager Aua = new 1();
    public static final HostnameVerifier Aub = new 2();

    public static SSLContext cJm() {
        SSLContext sSLContext = null;
        try {
            sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{Aua}, new SecureRandom());
            return sSLContext;
        } catch (Exception e) {
            return sSLContext;
        }
    }
}

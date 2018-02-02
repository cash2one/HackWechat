package com.tencent.xweb.xwalk.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class f$d$2 implements HostnameVerifier {
    f$d$2() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        if (str.contains("dldir1.qq.com")) {
            return true;
        }
        return false;
    }
}

package com.tencent.mm.plugin.appbrand.j;

import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class i$1 implements HostnameVerifier {
    final /* synthetic */ HostnameVerifier jBQ;
    final /* synthetic */ ArrayList jBR;

    i$1(HostnameVerifier hostnameVerifier, ArrayList arrayList) {
        this.jBQ = hostnameVerifier;
        this.jBR = arrayList;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return this.jBQ.verify(str, sSLSession) || i.b(this.jBR, str);
    }
}

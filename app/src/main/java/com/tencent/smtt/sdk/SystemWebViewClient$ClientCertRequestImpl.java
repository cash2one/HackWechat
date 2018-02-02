package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

class SystemWebViewClient$ClientCertRequestImpl extends ClientCertRequest {
    private android.webkit.ClientCertRequest mClientCertRequest;

    public SystemWebViewClient$ClientCertRequestImpl(android.webkit.ClientCertRequest clientCertRequest) {
        this.mClientCertRequest = clientCertRequest;
    }

    public void cancel() {
        this.mClientCertRequest.cancel();
    }

    public String getHost() {
        return this.mClientCertRequest.getHost();
    }

    public String[] getKeyTypes() {
        return this.mClientCertRequest.getKeyTypes();
    }

    public int getPort() {
        return this.mClientCertRequest.getPort();
    }

    public Principal[] getPrincipals() {
        return this.mClientCertRequest.getPrincipals();
    }

    public void ignore() {
        this.mClientCertRequest.ignore();
    }

    public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        this.mClientCertRequest.proceed(privateKey, x509CertificateArr);
    }
}

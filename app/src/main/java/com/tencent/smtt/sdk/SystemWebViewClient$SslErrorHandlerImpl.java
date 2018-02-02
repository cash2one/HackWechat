package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.SslErrorHandler;

class SystemWebViewClient$SslErrorHandlerImpl implements SslErrorHandler {
    android.webkit.SslErrorHandler mSslErrorHandler;

    SystemWebViewClient$SslErrorHandlerImpl(android.webkit.SslErrorHandler sslErrorHandler) {
        this.mSslErrorHandler = sslErrorHandler;
    }

    public void cancel() {
        this.mSslErrorHandler.cancel();
    }

    public void proceed() {
        this.mSslErrorHandler.proceed();
    }
}

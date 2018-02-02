package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;

class SystemWebViewClient$HttpAuthHandlerImpl implements HttpAuthHandler {
    private android.webkit.HttpAuthHandler mHandler;

    SystemWebViewClient$HttpAuthHandlerImpl(android.webkit.HttpAuthHandler httpAuthHandler) {
        this.mHandler = httpAuthHandler;
    }

    public void cancel() {
        this.mHandler.cancel();
    }

    public void proceed(String str, String str2) {
        this.mHandler.proceed(str, str2);
    }

    public boolean useHttpAuthUsernamePassword() {
        return this.mHandler.useHttpAuthUsernamePassword();
    }
}

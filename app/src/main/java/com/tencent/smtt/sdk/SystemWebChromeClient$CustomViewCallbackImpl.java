package com.tencent.smtt.sdk;

import android.webkit.WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

class SystemWebChromeClient$CustomViewCallbackImpl implements CustomViewCallback {
    WebChromeClient.CustomViewCallback mCustomViewCallback;
    final /* synthetic */ SystemWebChromeClient this$0;

    SystemWebChromeClient$CustomViewCallbackImpl(SystemWebChromeClient systemWebChromeClient, WebChromeClient.CustomViewCallback customViewCallback) {
        this.this$0 = systemWebChromeClient;
        this.mCustomViewCallback = customViewCallback;
    }

    public void onCustomViewHidden() {
        this.mCustomViewCallback.onCustomViewHidden();
    }
}

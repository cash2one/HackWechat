package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;

class SystemWebChromeClient$1 implements ab<String[]> {
    final /* synthetic */ SystemWebChromeClient this$0;
    final /* synthetic */ ValueCallback val$callback;

    SystemWebChromeClient$1(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.this$0 = systemWebChromeClient;
        this.val$callback = valueCallback;
    }

    public void onReceiveValue(String[] strArr) {
        this.val$callback.onReceiveValue(strArr);
    }
}

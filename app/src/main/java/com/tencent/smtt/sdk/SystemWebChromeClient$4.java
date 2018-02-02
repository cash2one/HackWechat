package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

class SystemWebChromeClient$4 implements ab<Uri[]> {
    final /* synthetic */ SystemWebChromeClient this$0;
    final /* synthetic */ ValueCallback val$myFilePathCallback;

    SystemWebChromeClient$4(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.this$0 = systemWebChromeClient;
        this.val$myFilePathCallback = valueCallback;
    }

    public void onReceiveValue(Uri[] uriArr) {
        this.val$myFilePathCallback.onReceiveValue(uriArr);
    }
}

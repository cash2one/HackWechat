package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

class SystemWebChromeClient$3 implements ab<Uri> {
    final /* synthetic */ SystemWebChromeClient this$0;
    final /* synthetic */ ValueCallback val$uploadFile;

    SystemWebChromeClient$3(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.this$0 = systemWebChromeClient;
        this.val$uploadFile = valueCallback;
    }

    public void onReceiveValue(Uri uri) {
        this.val$uploadFile.onReceiveValue(uri);
    }
}

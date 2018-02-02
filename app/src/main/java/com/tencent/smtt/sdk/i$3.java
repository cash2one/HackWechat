package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

class i$3 implements ab<Uri[]> {
    final /* synthetic */ ValueCallback val$myFilePathCallback;
    final /* synthetic */ i zWw;

    i$3(i iVar, ValueCallback valueCallback) {
        this.zWw = iVar;
        this.val$myFilePathCallback = valueCallback;
    }

    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
        this.val$myFilePathCallback.onReceiveValue((Uri[]) obj);
    }
}

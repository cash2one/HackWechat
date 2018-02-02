package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.f.a;

class f$a$1 implements ab<String> {
    final /* synthetic */ ValueCallback zVy;
    final /* synthetic */ a zVz;

    f$a$1(a aVar, ValueCallback valueCallback) {
        this.zVz = aVar;
        this.zVy = valueCallback;
    }

    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
        this.zVy.onReceiveValue((String) obj);
    }
}

package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;

public interface ab<T> extends ValueCallback<T> {
    void onReceiveValue(T t);
}

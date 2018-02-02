package com.tencent.mm.u.b;

import android.webkit.ValueCallback;

public interface d {
    boolean BZ();

    boolean Ca();

    void cleanup();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void pause();

    void resume();
}

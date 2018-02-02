package com.tencent.xweb.c;

import android.webkit.ValueCallback;
import com.tencent.xweb.d;
import java.net.URL;
import java.nio.ByteBuffer;

public interface f {
    boolean BZ();

    void a(d dVar);

    void addJavascriptInterface(Object obj, String str);

    boolean cIB();

    void cleanup();

    ByteBuffer ef(int i);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url);

    int getNativeBufferId();

    void init(int i);

    void pause();

    void resume();

    void setNativeBuffer(int i, ByteBuffer byteBuffer);
}

package com.tencent.mm.plugin.appbrand.g;

import android.webkit.ValueCallback;
import com.tencent.xweb.d;
import java.net.URL;

public interface b extends c {
    void a(d dVar);

    void a(URL url, String str, ValueCallback<String> valueCallback);

    void addJavascriptInterface(Object obj, String str);

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    <T extends c> T v(Class<T> cls);
}

package com.tencent.magicbrush.bind;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;

public interface V8JSInterface {
    @Keep
    @JavascriptInterface
    String invokeHandler(String str, String str2, int i);

    @Keep
    @JavascriptInterface
    boolean isDebugPackage();

    @Keep
    @JavascriptInterface
    void publishHandler(String str, String str2, String str3);

    @Keep
    @JavascriptInterface
    String retrieveEvent(int i);
}

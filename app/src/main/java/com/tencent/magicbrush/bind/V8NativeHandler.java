package com.tencent.magicbrush.bind;

import com.tencent.magicbrush.a.b;

public class V8NativeHandler {
    public native void nativeAddJsInterface(V8JSInterface v8JSInterface, String str);

    public native String nativeCheckError();

    public native void nativeCleanUp();

    public native String nativeEvaluateJavascript(String str);

    public native void nativeInit();

    public native void nativePause();

    public native void nativeResume();

    static {
        b.loadLibrary("mmv8");
        b.loadLibrary("magicbrush");
    }
}

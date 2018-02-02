package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.a.b;
import java.nio.ByteBuffer;

public class JsEngine {
    static native void addJsInterface(long j, Object obj, String str);

    static native long createVM();

    static native long createVMContext(long j);

    static native String evaluateJavascript(long j, String str);

    static native String evaluateJavascriptFile(long j, String str, String str2);

    static native ByteBuffer getNativeBuffer(int i, long j);

    public static native int getNativeBufferId();

    static native boolean pushObject(long j, long j2, String str);

    static native void releaseVM(long j);

    static native void releaseVMContext(long j);

    static native boolean removeJsInterface(long j, String str);

    static native boolean removeObject(long j, String str);

    public static native void setNativeBuffer(int i, ByteBuffer byteBuffer);

    JsEngine() {
    }

    static {
        b.loadLibrary("mmv8");
        b.loadLibrary("magicbrush");
    }
}

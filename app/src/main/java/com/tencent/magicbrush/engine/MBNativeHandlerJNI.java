package com.tencent.magicbrush.engine;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;

class MBNativeHandlerJNI {
    @Keep
    static native MBCanvasContentHolder nativeCaptureCanvasSnapshot(int i);

    @Keep
    static native MBCanvasContentHolder nativeCaptureScreenshot();

    @Keep
    static native void nativeOnImageDecoded(String str, Bitmap bitmap);

    @Keep
    static native void nativeSetSDCardPath(boolean z, boolean z2, String str);

    @Keep
    static native void nativeSetSecureCanvasModeEnable(boolean z);

    @Keep
    static native void nativeSetV8Debug(boolean z);

    MBNativeHandlerJNI() {
    }

    static {
        b.loadLibrary("mmv8");
        b.loadLibrary("magicbrush");
    }
}

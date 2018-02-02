package com.tencent.magicbrush.engine;

import android.graphics.Bitmap;
import android.os.Environment;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;

public final class c {
    public static String bnD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String bnE = "/tencent/MicroMsg/AppBrandGame";
    public static String bnF = (bnD + bnE);

    public static void a(String str, Bitmap bitmap) {
        MBNativeHandlerJNI.nativeOnImageDecoded(str, bitmap);
    }

    public static MBCanvasContentHolder sC() {
        return MBNativeHandlerJNI.nativeCaptureScreenshot();
    }

    public static MBCanvasContentHolder eg(int i) {
        return MBNativeHandlerJNI.nativeCaptureCanvasSnapshot(i);
    }

    public static void az(boolean z) {
        MBNativeHandlerJNI.nativeSetV8Debug(z);
    }
}

package com.tencent.magicbrush.handler;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.magicbrush.handler.image.b;

public class MBImageHandlerJNI {
    private static b sProxy;

    public static void register(b bVar) {
        sProxy = bVar;
    }

    @Keep
    public static void init() {
        sProxy.init();
    }

    @Keep
    public static void release() {
        sProxy.release();
    }

    @Keep
    public static Bitmap getBitmap(int i, int i2) {
        if (sProxy != null) {
            return sProxy.getBitmap(i, i2);
        }
        throw new IllegalStateException("ImageHandler not impl");
    }

    @Keep
    public static String toDataURL(Bitmap bitmap, String str, float f) {
        if (sProxy != null) {
            return sProxy.toDataURL(bitmap, str, f);
        }
        throw new IllegalStateException("ImageHandler not impl");
    }

    @Keep
    public static void releaseBitmap(Bitmap bitmap) {
        if (sProxy == null) {
            throw new IllegalStateException("ImageHandler not impl");
        }
        sProxy.releaseBitmap(bitmap);
    }

    @Keep
    public static Bitmap loadBitmapSync(String str) {
        if (sProxy != null) {
            return sProxy.loadBitmapSync(str);
        }
        throw new IllegalStateException("ImageHandler not impl");
    }

    @Keep
    public static void loadBitmapAsync(String str) {
        if (sProxy == null) {
            throw new IllegalStateException("ImageHandler not impl");
        }
        sProxy.loadBitmapAsync(str);
    }
}

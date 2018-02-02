package com.tencent.magicbrush.jni;

import android.graphics.Bitmap;

public class UtilsJNI {
    public static native void texSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap);
}

package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;

public interface b {
    Bitmap getBitmap(int i, int i2);

    void init();

    void loadBitmapAsync(String str);

    Bitmap loadBitmapSync(String str);

    void release();

    void releaseBitmap(Bitmap bitmap);

    String toDataURL(Bitmap bitmap, String str, float f);
}

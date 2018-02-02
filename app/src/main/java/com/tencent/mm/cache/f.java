package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.os.IInterface;

public interface f extends IInterface {
    void b(String str, Bitmap bitmap);

    MCacheItem em(String str);

    void en(String str);

    Bitmap getBitmap(String str);
}

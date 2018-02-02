package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;

public interface d {
    int getDurationMs();

    Bitmap getFrameAtTime(long j);

    int getScaledHeight();

    int getScaledWidth();

    void init(String str, int i, int i2, int i3);

    void release();

    void reuseBitmap(Bitmap bitmap);
}

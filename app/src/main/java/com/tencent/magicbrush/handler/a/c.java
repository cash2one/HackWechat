package com.tencent.magicbrush.handler.a;

import android.graphics.Bitmap;
import java.nio.FloatBuffer;

public interface c {
    boolean checkAndFlushClearSignal();

    int[] checkAndFlushDirtySignal();

    FloatBuffer drawText(String str);

    void enableStroke(boolean z);

    Bitmap getBitmapAtlas();

    float getTextLineHeight(String str);

    void init(int i, int i2);

    String loadFont(String str);

    float measureText(String str);

    void release();

    void setStrokeWidth(float f);

    void useFont(String str, float f, boolean z, boolean z2);
}

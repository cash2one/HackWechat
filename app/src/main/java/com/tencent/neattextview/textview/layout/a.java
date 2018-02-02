package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public interface a extends Serializable {
    void a(Canvas canvas, TextPaint textPaint, float f);

    float[] cCq();

    RectF cCr();

    float cCs();

    boolean cCt();

    float cCu();

    int getEnd();

    float getHeight();

    int getStart();

    float getWidth();
}

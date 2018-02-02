package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class CameraFrontSightView extends View {
    Paint fC = new Paint();
    int jUU;
    public int mHeight;
    public int mWidth;
    boolean oAD = false;
    boolean oAE = false;
    boolean oAF = false;
    boolean oAG = false;
    long oAH = 0;
    int oAI;
    int oAJ;
    LayoutParams oAK;

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void draw(Canvas canvas) {
        canvas.translate((float) (this.oAI / 2), (float) (this.oAJ / 2));
        long currentTimeMillis = System.currentTimeMillis() - this.oAH;
        if (currentTimeMillis > 200) {
            this.oAD = false;
            this.oAE = true;
        }
        if (currentTimeMillis > 800) {
            this.oAE = false;
            this.oAF = true;
        }
        if (currentTimeMillis > 1100) {
            this.oAF = false;
            this.oAG = true;
        }
        if (currentTimeMillis > 1300) {
            this.oAG = false;
            setVisibility(8);
            return;
        }
        if (this.oAD) {
            float f = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f, f, (float) (this.oAI / 2), (float) (this.oAJ / 2));
            this.fC.setAlpha((int) ((2.0f - f) * 255.0f));
        } else {
            canvas.scale(1.0f, 1.0f);
        }
        if (this.oAE) {
            f = (((float) ((currentTimeMillis - 200) % 200)) / 200.0f) * 2.0f;
            this.fC.setAlpha((int) (((f > 1.0f ? f - 1.0f : 1.0f - f) * 128.0f) + 127.0f));
        } else {
            this.fC.setAlpha(255);
        }
        if (this.oAG) {
            this.fC.setAlpha((int) ((1.0f - (((float) (currentTimeMillis - 1100)) / 200.0f)) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, (float) this.oAI, 0.0f, this.fC);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.oAJ, this.fC);
        canvas.drawLine((float) this.oAI, 0.0f, (float) this.oAI, (float) this.oAJ, this.fC);
        canvas.drawLine(0.0f, (float) this.oAJ, (float) this.oAI, (float) this.oAJ, this.fC);
        canvas.drawLine(0.0f, (float) (this.oAJ / 2), (float) (this.oAI / 10), (float) (this.oAJ / 2), this.fC);
        canvas.drawLine((float) this.oAI, (float) (this.oAJ / 2), (float) ((this.oAI * 9) / 10), (float) (this.oAJ / 2), this.fC);
        canvas.drawLine((float) (this.oAI / 2), 0.0f, (float) (this.oAI / 2), (float) (this.oAJ / 10), this.fC);
        canvas.drawLine((float) (this.oAI / 2), (float) this.oAJ, (float) (this.oAI / 2), (float) ((this.oAJ * 9) / 10), this.fC);
        invalidate();
    }
}

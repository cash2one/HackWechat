package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class GyroView extends View {
    private float Wo = (20.0f * getResources().getDisplayMetrics().density);
    private Paint fC = new Paint(1);
    private float xVN = 0.0f;
    private float xVO = 0.0f;
    private float xVP = (100.0f * getResources().getDisplayMetrics().density);
    private float xVQ = (40.0f * getResources().getDisplayMetrics().density);
    private float xVR = (10.0f * getResources().getDisplayMetrics().density);
    private float xVS = (6.0f * getResources().getDisplayMetrics().density);
    private boolean xVT = false;

    public GyroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fC.setStyle(Style.FILL);
        this.fC.setColor(-4737097);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = ((float) getMeasuredWidth()) / 2.0f;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (this.xVO > 0.0f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (this.xVR / 2.0f) - ((this.xVO * (this.xVR - this.xVS)) / 2.0f), this.fC);
            canvas.drawCircle(measuredWidth - (this.xVO * this.Wo), measuredHeight, this.xVS / 2.0f, this.fC);
            canvas.drawCircle(measuredWidth + (this.xVO * this.Wo), measuredHeight, this.xVS / 2.0f, this.fC);
            return;
        }
        canvas.drawCircle(measuredWidth, measuredHeight, (this.xVN * this.xVR) / 2.0f, this.fC);
    }

    public final void aC(float f) {
        float f2 = (f - this.xVQ) / (this.xVP - this.xVQ);
        if (this.xVT) {
            f2 = 1.0f - f2;
        }
        this.xVO = Math.max(0.0f, Math.min(f2, 1.0f));
        f2 = f / this.xVQ;
        if (this.xVT) {
            f2 = 1.0f - f2;
        }
        this.xVN = Math.max(0.0f, Math.min(f2, 1.0f));
        postInvalidate();
    }
}

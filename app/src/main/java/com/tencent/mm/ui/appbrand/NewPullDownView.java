package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

public class NewPullDownView extends View {
    private float xVN = 0.0f;
    private boolean xVT = false;
    private float xVU = (20.0f * getResources().getDisplayMetrics().density);
    private float xVV = ((14.0f * getResources().getDisplayMetrics().density) - (getResources().getDisplayMetrics().density * 4.0f));
    private Paint xVW = new Paint(1);
    private Paint xVX;

    public NewPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xVW.setStyle(Style.FILL);
        this.xVW.setColor(-4408132);
        this.xVX = new Paint(1);
        this.xVX.setStyle(Style.STROKE);
        this.xVX.setColor(0);
        this.xVX.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        this.xVX.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) (getMeasuredHeight() / 2);
        canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        canvas.drawCircle(measuredWidth, measuredHeight, (this.xVN * this.xVU) / 2.0f, this.xVW);
        if (this.xVN >= 0.4f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (((this.xVN - 0.4f) / 0.6f) * this.xVV) / 2.0f, this.xVX);
        }
        canvas.restore();
    }
}

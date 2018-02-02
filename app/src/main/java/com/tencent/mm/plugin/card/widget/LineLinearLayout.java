package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.bv.a;

public class LineLinearLayout extends LinearLayout {
    private Paint fC;
    private Rect fD;
    private int kYI;

    public LineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.fD = new Rect();
        this.fC = new Paint();
        this.fC.setStyle(Style.STROKE);
        this.fC.setColor(-571543826);
        this.fC.setStrokeWidth((float) Math.round(a.getDensity(getContext()) * 0.5f));
        this.kYI = a.fromDPToPix(context, 44);
    }

    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        Paint paint = this.fC;
        for (int i = 1; this.kYI * i < measuredHeight; i++) {
            canvas.drawLine(0.0f, (float) (this.kYI * i), (float) getMeasuredWidth(), (float) (this.kYI * i), paint);
        }
        super.onDraw(canvas);
    }
}

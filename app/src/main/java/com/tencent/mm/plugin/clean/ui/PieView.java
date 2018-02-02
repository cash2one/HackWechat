package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    public int fBs = 0;
    private int jer = 6;
    private Paint lfV;
    private Paint lfW;
    private Paint lfX;
    private Paint lfY;
    private Paint lfZ;
    private Paint lga;
    private Paint lgb;
    private int lgc;
    private int lgd;
    private int lge;
    private int lgf;
    public int lgg;
    private int lgh;
    public int lgi = 0;
    private int lgj = -90;

    public PieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        this.lfV = oj(-1);
        this.lfW = oj(-657931);
        this.lfX = oj(-2565928);
        this.lfY = oj(-15223279);
        this.lfZ = oj(-7876878);
        this.lga = oj(-7876878);
        this.lgb = oj(-1644567);
    }

    private static Paint oj(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(i);
        return paint;
    }

    public void draw(Canvas canvas) {
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) ((getMeasuredHeight() / 2) + getTop());
        float measuredHeight2 = (float) ((getMeasuredHeight() / 3) + 15);
        float f = measuredHeight2 - 15.0f;
        RectF rectF = new RectF(measuredWidth - measuredHeight2, measuredHeight - measuredHeight2, measuredWidth + measuredHeight2, measuredHeight + measuredHeight2);
        if (this.fBs == 0) {
            canvas.drawCircle(measuredWidth, measuredHeight, measuredHeight2, this.lfW);
            canvas.drawArc(rectF, (float) this.lgj, 45.0f, true, this.lfX);
            canvas.drawCircle(measuredWidth, measuredHeight, f, this.lfV);
            this.lgj += 4;
            this.lgj %= 360;
        }
        if (this.fBs == 1) {
            float f2 = 10.0f + measuredHeight2;
            RectF rectF2 = new RectF(measuredWidth - f2, measuredHeight - f2, measuredWidth + f2, f2 + measuredHeight);
            this.lgc = H(this.lgc, this.lgg, this.jer);
            canvas.drawArc(rectF2, -90.0f, (float) this.lgc, true, this.lfY);
            if (this.lgi <= 0) {
                if (this.lgc == this.lgg) {
                    this.lge = H(this.lge, this.lgh, this.jer);
                    canvas.drawArc(rectF, (float) (this.lgg - 90), (float) this.lge, true, this.lfZ);
                }
                if (this.lge == this.lgh) {
                    this.lgd = H(this.lgd, (360 - this.lgg) - this.lgh, this.jer);
                    canvas.drawArc(rectF, (float) ((this.lgg - 90) + this.lgh), (float) this.lgd, true, this.lga);
                }
            } else {
                if (this.lgc == this.lgg) {
                    this.lgf = H(this.lgf, this.lgi, this.jer);
                    canvas.drawArc(rectF2, (float) (this.lgg - 90), (float) this.lgf, true, this.lgb);
                }
                if (this.lgf == this.lgi) {
                    this.lge = H(this.lge, this.lgh, this.jer);
                    canvas.drawArc(rectF, (float) ((this.lgi - 90) + this.lgg), (float) this.lge, true, this.lfZ);
                }
                if (this.lge == this.lgh) {
                    this.lgd = H(this.lgd, ((360 - this.lgg) - this.lgh) - this.lgi, this.jer);
                    canvas.drawArc(rectF, (float) (((this.lgg - 90) + this.lgh) + this.lgi), (float) this.lgd, true, this.lga);
                }
            }
        }
        invalidate();
    }

    private static int H(int i, int i2, int i3) {
        if (i2 - i >= i3) {
            return i + i3;
        }
        if (i - i2 > i3) {
            return i - i3;
        }
        return i2;
    }
}

package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bv.a;

public class CardTagTextView extends TextView {
    public int fillColor = 0;
    private int kPr = 3;
    private RectF kXO = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private Paint kXP = new Paint();
    private int kXQ = 9;
    private int kXR = 0;

    public CardTagTextView(Context context) {
        super(context);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.kPr = Math.round(a.getDensity(getContext()) * 0.5f);
        this.kXQ = a.fromDPToPix(getContext(), 3);
        this.kXR = getCurrentTextColor();
    }

    public void setTextColor(int i) {
        this.kXR = i;
        super.setTextColor(i);
    }

    protected void onDraw(Canvas canvas) {
        this.kXO.left = (float) this.kXQ;
        this.kXO.top = (float) this.kPr;
        this.kXO.right = (float) (getWidth() - this.kXQ);
        this.kXO.bottom = (float) (getHeight() - this.kPr);
        if (this.fillColor != 0) {
            this.kXP.setColor(this.fillColor);
            this.kXP.setStyle(Style.FILL);
            canvas.drawRoundRect(this.kXO, (float) ((getHeight() / 2) - this.kPr), (float) ((getHeight() / 2) - this.kPr), this.kXP);
        }
        this.kXP.setColor(this.kXR);
        this.kXP.setStrokeWidth((float) this.kPr);
        this.kXP.setStyle(Style.STROKE);
        canvas.drawRoundRect(this.kXO, (float) ((getHeight() / 2) - this.kPr), (float) ((getHeight() / 2) - this.kPr), this.kXP);
        super.onDraw(canvas);
    }
}

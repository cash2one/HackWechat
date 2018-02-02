package com.tencent.mm.plugin.sns.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.l;

public class SnsTextProgressBar extends ProgressBar {
    private Paint fC;
    private String jUJ;
    private int jtP;
    private Context mContext;
    public String rRQ;
    private int sm;

    public SnsTextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l.qNh, 0, 0);
        try {
            this.jtP = a.fromDPToPix(this.mContext, obtainStyledAttributes.getInteger(l.qNi, 18));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(int i) {
        this.sm = i;
        this.jUJ = String.valueOf(i) + "%";
        super.setProgress(i);
    }

    @SuppressLint({"DrawAllocation"})
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.fC = new Paint();
        this.fC.setAntiAlias(true);
        int color = (this.rRQ == null || this.rRQ.length() <= 0) ? this.mContext.getResources().getColor(c.qyH) : Color.parseColor(this.rRQ);
        this.fC.setColor(color);
        this.fC.setTextSize((float) this.jtP);
        Rect rect = new Rect();
        this.fC.getTextBounds(this.jUJ, 0, this.jUJ.length(), rect);
        canvas.drawText(this.jUJ, (float) ((getWidth() / 2) - rect.centerX()), (float) ((getHeight() / 2) - rect.centerY()), this.fC);
    }
}

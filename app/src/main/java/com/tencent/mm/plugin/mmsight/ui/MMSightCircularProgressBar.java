package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.u.a.b;

public class MMSightCircularProgressBar extends View {
    int duration = 0;
    boolean fAs = false;
    private Paint iYm;
    float oAM = 0.0f;
    int oAN = 0;
    int oAO = 0;
    private RectF oAP;
    b oAQ;
    a oAR;
    private int oAS = Color.parseColor("#1AAD19");
    private float strokeWidth = 0.0f;
    private float zA = 0.0f;

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(b.oEn);
        this.strokeWidth = (float) getResources().getDimensionPixelSize(b.oEp);
        this.zA = this.strokeWidth / 2.0f;
        this.oAP = new RectF(this.zA, this.zA, dimensionPixelSize - this.zA, dimensionPixelSize - this.zA);
        this.iYm = new Paint();
        this.iYm.setStyle(Style.STROKE);
        this.iYm.setStrokeWidth(this.strokeWidth);
        this.iYm.setColor(this.oAS);
        this.iYm.setAlpha(153);
        this.iYm.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.zA, this.zA);
        canvas.rotate(180.0f, this.oAP.right / 2.0f, this.oAP.bottom / 2.0f);
        canvas.drawArc(this.oAP, 90.0f, 360.0f * (this.oAM / ((float) this.oAO)), false, this.iYm);
        canvas.restore();
    }
}

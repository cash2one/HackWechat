package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public final class m implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    public static float tVN = 0.0f;
    private float nxC = 10.0f;
    private final int tVC;
    public boolean tVD;
    private final int tVL;
    private float tVM;

    public final /* synthetic */ f bXw() {
        return new m(this.tVL, this.tVC, this.tVD);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public m(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.tVL = i;
        this.tVC = i2;
        boolean z4 = z && z3 && !z2;
        this.tVD = z4;
    }

    private m(int i, int i2, boolean z) {
        this.tVL = i;
        this.tVC = i2;
        this.tVD = z;
    }

    public final int getLeadingMargin(boolean z) {
        tVN = (float) Math.max(Math.round(this.tVM + 2.0f > tVN ? this.tVM + 2.0f : tVN), this.tVC);
        return this.tVD ? 0 : (int) tVN;
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.tVD && spanned.getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            float textSize = paint.getTextSize();
            paint.setStyle(Style.FILL);
            this.nxC = (float) (i4 - i3);
            this.tVM = paint.measureText(this.tVL + ".");
            canvas.drawText(this.tVL + ".", (float) i, (float) i4, paint);
            paint.setStyle(style);
            paint.setTextSize(textSize);
        }
    }
}

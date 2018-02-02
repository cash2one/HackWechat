package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import java.util.Iterator;
import java.util.List;

public class c extends b<ClickableSpan> {
    public boolean ozA;

    public c(int i, int i2, ClickableSpan clickableSpan) {
        super(i, i2, clickableSpan);
    }

    public final void a(Canvas canvas, TextPaint textPaint, List<com.tencent.neattextview.textview.layout.c> list) {
        dE(list);
        if (this.ozA) {
            int color = textPaint.getColor();
            int i = textPaint.bgColor;
            boolean isUnderlineText = textPaint.isUnderlineText();
            ((ClickableSpan) this.zKr).updateDrawState(textPaint);
            textPaint.setColor(textPaint.bgColor);
            Iterator it = this.zKq.iterator();
            while (it.hasNext()) {
                canvas.drawRect((RectF) it.next(), textPaint);
            }
            textPaint.setColor(color);
            textPaint.setUnderlineText(isUnderlineText);
            textPaint.bgColor = i;
            this.ozA = false;
        }
    }
}

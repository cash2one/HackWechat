package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

final class ag$b extends Drawable {
    private final int hX;
    private final String jUJ;
    private final TextPaint jZQ;
    private Rect jZR;

    private ag$b(String str, int i) {
        this.jUJ = str;
        this.hX = i;
        this.jZQ = new TextPaint();
        this.jZQ.setAntiAlias(true);
        this.jZQ.setTextAlign(Align.CENTER);
        this.jZQ.setTextSize((float) this.hX);
        this.jZR = new Rect();
        this.jZQ.getTextBounds(this.jUJ, 0, this.jUJ.length(), this.jZR);
    }

    public final int getIntrinsicWidth() {
        return this.jZR.width();
    }

    public final int getIntrinsicHeight() {
        return this.jZR.height();
    }

    public final void draw(Canvas canvas) {
        canvas.drawText(this.jUJ, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.jZQ.descent() + this.jZQ.ascent()) / 2.0f), this.jZQ);
    }

    public final void setAlpha(int i) {
        this.jZQ.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.jZQ.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}

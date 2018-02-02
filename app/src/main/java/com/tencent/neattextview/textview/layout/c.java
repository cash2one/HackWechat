package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.layout.b.1;
import com.tencent.neattextview.textview.layout.b.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class c implements a {
    private static final TextPaint zKX = new TextPaint(1);
    private static Comparator<Integer> zKY = new 1();
    public int Ww;
    private float tVM;
    public int wq;
    private b zKZ;
    private float[] zKw;
    private char[] zLa;
    private float zLb;
    private boolean zLc;
    private float zLd;
    private float zLe = -1.0f;
    private RectF zLf = new RectF();
    private LinkedList<Integer> zLg = null;

    public c(b bVar, char[] cArr, int i, int i2, float f, float[] fArr, float f2, float f3, float f4, TextPaint textPaint, boolean z) {
        this.zKZ = bVar;
        this.zLa = cArr;
        this.Ww = i;
        this.wq = i2;
        this.zKw = fArr;
        this.zLb = f4;
        this.zLc = z;
        this.zLd = f3;
        this.tVM = f2;
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f5 = fontMetrics.leading - fontMetrics.top;
        float f6 = fontMetrics.bottom - fontMetrics.leading;
        float f7 = ((((this.zLd - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        this.zLf.set(0.0f, f7 - f5, 0.0f + f2, f7 + f6);
    }

    public final void a(Canvas canvas, TextPaint textPaint, float f) {
        float cCu = 0.0f + cCu();
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = ((((this.zLd - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
        int i;
        int i2;
        ImageSpan imageSpan;
        float f3;
        if (this.zLb != 0.0f || this.zLc) {
            i = this.Ww;
            int i3 = this.Ww;
            float f4 = f2;
            while (i3 < this.wq) {
                if (i3 + 1 >= this.wq || this.zKw[i3 + 1] != 0.0f) {
                    i2 = i3 + 1;
                    imageSpan = (ImageSpan) this.zKZ.zKG.fz(i, i2);
                    if (imageSpan != null) {
                        zKX.set(textPaint);
                        imageSpan.draw(canvas, "", i, i2, cCu, 0, (int) f4, (int) (this.zLd + f), zKX);
                    } else {
                        if (a(textPaint, i, i2)) {
                            f3 = ((((this.zLd - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
                        } else {
                            f3 = f4;
                        }
                        canvas.drawText(this.zLa, i, i2 - i, cCu, f3, zKX);
                        f4 = f3;
                    }
                    cCu += this.zKw[i] + this.zLb;
                    i = i2;
                    f2 = f4;
                } else {
                    f2 = f4;
                }
                i3++;
                f4 = f2;
            }
            return;
        }
        i = this.Ww;
        i2 = this.wq;
        if (this.zLg == null) {
            this.zLg = new LinkedList();
            for (int i4 : a.cCy()) {
                if (i4 != a.zKR) {
                    d dVar;
                    b bVar = this.zKZ;
                    switch (1.zKP[i4 - 1]) {
                        case 1:
                            dVar = bVar.zKL;
                            break;
                        case 2:
                            dVar = bVar.zKJ;
                            break;
                        case 3:
                            dVar = bVar.zKG;
                            break;
                        case 4:
                            dVar = bVar.zKH;
                            break;
                        case 5:
                            dVar = bVar.zKI;
                            break;
                        case 6:
                            dVar = bVar.zKK;
                            break;
                        default:
                            dVar = null;
                            break;
                    }
                    int i5 = 0;
                    for (boolean z : dVar.fA(i, i2)) {
                        if (z) {
                            this.zLg.add(Integer.valueOf(dVar.zLk[i5] < i ? i : dVar.zLk[i5]));
                            this.zLg.add(Integer.valueOf(dVar.zLl[i5] > i2 ? i2 : dVar.zLl[i5]));
                        }
                        i5++;
                    }
                }
            }
            Collections.sort(this.zLg, zKY);
        }
        i = this.Ww;
        Iterator it = this.zLg.iterator();
        f3 = f2;
        while (it.hasNext()) {
            i2 = ((Integer) it.next()).intValue();
            if (i2 > 0 && i != i2) {
                imageSpan = (ImageSpan) this.zKZ.zKG.fB(i, i2);
                if (imageSpan != null) {
                    zKX.set(textPaint);
                    imageSpan.draw(canvas, "", i, i2, cCu, 0, (int) f3, (int) (this.zLd + f), zKX);
                } else {
                    if (a(textPaint, i, i2)) {
                        f3 = ((((this.zLd - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
                    }
                    canvas.drawText(this.zLa, i, i2 - i, cCu, f3, zKX);
                }
                while (i < i2) {
                    cCu += this.zKw[i];
                    i++;
                }
                i = i2;
            }
        }
        if (i < this.Ww + getLength()) {
            float f5;
            if (a(textPaint, i, this.Ww + getLength())) {
                f5 = ((((this.zLd - fontMetrics.bottom) + fontMetrics.top) / 2.0f) + f) - fontMetrics.top;
            } else {
                f5 = f3;
            }
            canvas.drawText(this.zLa, i, (this.Ww + getLength()) - i, cCu, f5, zKX);
        }
    }

    public final float getHeight() {
        return this.zLd;
    }

    public final float getWidth() {
        return this.tVM;
    }

    public final float[] cCq() {
        return this.zKw;
    }

    private int getLength() {
        return this.wq - this.Ww;
    }

    public final RectF fy(int i, int i2) {
        RectF rectF = new RectF();
        if (i < i2) {
            float cCu = cCu();
            for (int i3 = this.Ww; i3 < i; i3++) {
                cCu += this.zKw[i3] + this.zLb;
            }
            float f = cCu;
            while (i < i2) {
                f += this.zKw[i] + this.zLb;
                i++;
            }
            rectF.set(cCu, this.zLf.top, f, this.zLf.bottom);
        }
        return rectF;
    }

    public final RectF cCr() {
        return this.zLf;
    }

    public final int getStart() {
        return this.Ww;
    }

    public final int getEnd() {
        return this.wq;
    }

    public final float cCs() {
        return this.zLb;
    }

    public final boolean cCt() {
        return this.zLc;
    }

    public final float cCu() {
        if (this.zLe != -1.0f) {
            return this.zLe;
        }
        if (this.zKZ.zKG.fz(this.Ww, this.Ww + 1) == null && this.zKZ.cCw().containsKey(Character.valueOf(this.zLa[this.Ww]))) {
            float f = -((Float) this.zKZ.cCw().get(Character.valueOf(this.zLa[this.Ww]))).floatValue();
            this.zLe = f;
            return f;
        }
        this.zLe = 0.0f;
        return this.zLe;
    }

    private boolean a(TextPaint textPaint, int i, int i2) {
        boolean z = true;
        boolean z2 = false;
        zKX.set(textPaint);
        AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) this.zKZ.zKH.fz(i, i2);
        if (absoluteSizeSpan != null) {
            absoluteSizeSpan.updateDrawState(zKX);
            z2 = true;
        }
        RelativeSizeSpan relativeSizeSpan = (RelativeSizeSpan) this.zKZ.zKI.fz(i, i2);
        if (relativeSizeSpan != null) {
            relativeSizeSpan.updateDrawState(zKX);
        } else {
            z = z2;
        }
        ForegroundColorSpan foregroundColorSpan = (ForegroundColorSpan) this.zKZ.zKK.fz(i, i2);
        if (foregroundColorSpan != null) {
            foregroundColorSpan.updateDrawState(zKX);
        }
        ClickableSpan clickableSpan = (ClickableSpan) this.zKZ.zKL.fz(i, i2);
        if (clickableSpan != null) {
            clickableSpan.updateDrawState(zKX);
        }
        return z;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.getStart() != this.Ww || aVar.getEnd() != this.wq || !aVar.cCr().equals(this.zLf) || aVar.cCt() != this.zLc || aVar.cCs() != this.zLb || aVar.cCu() != this.zLe) {
            return false;
        }
        for (int i = this.Ww; i < this.wq; i++) {
            if (this.zKw[i] != aVar.cCq()[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((((this.Ww + this.wq) + ((int) this.zLd)) + ((int) this.tVM)) + ((int) this.zLe)) + this.zLf.hashCode();
    }

    public final String toString() {
        return "MeasuredLine{mStart=" + this.Ww + ", mEnd=" + this.wq + ", mLetter=" + this.zLb + ", isSmartLetter=" + this.zLc + ", mHeight=" + this.zLd + ", mWidth=" + this.tVM + ", mLeftOffset=" + this.zLe + ", mLineRect=" + this.zLf + '}';
    }
}

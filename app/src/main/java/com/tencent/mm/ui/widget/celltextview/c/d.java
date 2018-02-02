package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.celltextview.g.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class d {
    protected static Paint zxs = new Paint(1);
    protected Paint fC;
    protected String jUJ;
    protected int jjf;
    protected int mType;
    protected int su;
    protected float zxq;
    protected boolean zxr;

    private d(Paint paint, int i, int i2, float f, String str, boolean z) {
        this.mType = 0;
        this.su = i;
        this.jjf = i2;
        this.zxq = f;
        this.jUJ = str;
        this.zxr = z;
        this.fC = paint;
    }

    public d(Paint paint, String str, float f) {
        this.mType = 0;
        this.mType = 0;
        this.zxq = f;
        this.jUJ = str;
        this.fC = paint;
    }

    public final String toString() {
        return "type:" + this.mType + ", Text:" + (this.jUJ == null ? "" : this.jUJ) + ", Size:" + this.zxq + ", Color:" + this.su;
    }

    public final String getText() {
        return this.jUJ;
    }

    public final int getType() {
        return this.mType;
    }

    public static boolean czl() {
        return true;
    }

    public final int czm() {
        int i = 1;
        x.d("NewTextCell", "[getHashcode] mSize:%s ,mBgColor:%s,mColor:%s,mType:%s,hashCode:%s", new Object[]{Float.valueOf(this.zxq), Integer.valueOf(this.jjf), Integer.valueOf(this.su), Integer.valueOf(this.mType), Integer.valueOf(this.jUJ.hashCode())});
        float f = ((this.zxq + ((float) this.jjf)) + ((float) this.su)) + ((float) this.mType);
        if (!this.zxr) {
            i = 2;
        }
        return ((int) (((float) i) + f)) * r2;
    }

    public final int getLength() {
        if (this.jUJ != null) {
            return this.jUJ.length();
        }
        return 0;
    }

    public final void v(int i, int i2, String str) {
        if (i < 0) {
            i = 0;
        }
        if (i2 > this.jUJ.length() || i2 < 0) {
            i2 = this.jUJ.length();
        }
        this.jUJ = this.jUJ.substring(i, i2);
        if (!TextUtils.isEmpty(str)) {
            this.jUJ += str;
        }
    }

    public final float Hh(int i) {
        czo();
        FontMetrics fontMetrics = zxs.getFontMetrics();
        return (fontMetrics.bottom - fontMetrics.top) + ((float) i);
    }

    public final int a(int i, int i2, float[] fArr) {
        if (TextUtils.isEmpty(this.jUJ)) {
            return 0;
        }
        czo();
        int i3 = i + i2;
        if (i3 > this.jUJ.length()) {
            i3 = this.jUJ.length();
        }
        if (i < i3) {
            return zxs.getTextWidths(this.jUJ, i, i3, fArr);
        }
        return 0;
    }

    public final float l(int i, float f) {
        if (TextUtils.isEmpty(this.jUJ)) {
            return 0.0f;
        }
        czo();
        int i2 = i + 0;
        if (i2 > this.jUJ.length()) {
            i2 = this.jUJ.length();
        }
        if (i2 <= 0) {
            return 0.0f;
        }
        float[] fArr = new float[i];
        i2 = zxs.getTextWidths(this.jUJ, 0, i2, fArr);
        float f2 = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            f2 += fArr[i3];
        }
        return (((float) i2) * f) + f2;
    }

    public final d czn() {
        return new d(this.fC, this.su, this.jjf, this.zxq, this.jUJ, this.zxr);
    }

    public final void a(Canvas canvas, RectF rectF, float f, float f2) {
        int i = 0;
        czo();
        float height = rectF.top + ((float) ((int) (((rectF.height() - zxs.descent()) - zxs.ascent()) / 2.0f)));
        float f3 = rectF.left;
        String str = this.jUJ;
        Paint paint = zxs;
        canvas.save();
        char charAt = str.charAt(0);
        if (a.s(charAt)) {
            canvas.translate(-a.b(charAt, paint), 0.0f);
        }
        boolean isUnderlineText = paint.isUnderlineText();
        paint.setUnderlineText(false);
        char[] cArr = new char[str.length()];
        str.getChars(0, str.length(), cArr, 0);
        if (this.jjf != 0) {
            paint.setColor(this.jjf);
            paint.setStyle(Style.FILL);
            canvas.drawRect(rectF, paint);
            paint.setStyle(Style.STROKE);
            paint.setColor(this.su);
        }
        int i2 = -1;
        while (i < str.length()) {
            char c = cArr[i];
            if (Character.isHighSurrogate(c)) {
                if (-1 == i2) {
                    i2 = i;
                }
                i++;
            } else {
                if (-1 != i2) {
                    String substring = str.substring(i2, i);
                    canvas.drawText(substring, f3, height, paint);
                    f3 += paint.measureText(substring) + f;
                    i2 = -1;
                }
                String ch = Character.toString(c);
                canvas.drawText(ch, f3, height, paint);
                f3 += paint.measureText(ch) + f;
            }
            i++;
        }
        if (-1 != i2) {
            String substring2 = str.substring(i2, str.length());
            canvas.drawText(substring2, f3, height, paint);
            f3 += paint.measureText(substring2) + f;
        }
        if (isUnderlineText) {
            float strokeWidth = paint.getStrokeWidth();
            Style style = paint.getStyle();
            paint.setStrokeWidth(paint.getTextSize() / 15.0f);
            paint.setStyle(Style.FILL);
            float strokeWidth2 = (paint.getStrokeWidth() * DownloadHelper.SAVE_FATOR) + (paint.getFontMetrics().leading + height);
            canvas.drawLine(f3, strokeWidth2, f3, strokeWidth2, paint);
            paint.setStrokeWidth(strokeWidth);
            paint.setStyle(style);
        }
        paint.setUnderlineText(isUnderlineText);
        canvas.restore();
    }

    public final void czo() {
        zxs.set(this.fC);
        zxs.setColor(this.su);
        zxs.setTextSize(this.zxq);
        zxs.setUnderlineText(this.zxr);
    }
}

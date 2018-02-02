package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.a.a;
import com.tencent.neattextview.textview.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class b {
    private static final char[] zKs = new char[]{'…'};
    private static final String zKt = new String(zKs);
    protected TextPaint gu;
    protected CharSequence mText;
    private float tVN;
    protected HashMap<Character, Float> zKA = new HashMap(a.zKo.length);
    public LinkedList<com.tencent.neattextview.textview.b.b> zKB = new LinkedList();
    private float zKC;
    private float zKD;
    private TextPaint zKE = new TextPaint();
    private float[] zKF;
    d<ImageSpan> zKG = new d(ImageSpan.class);
    d<AbsoluteSizeSpan> zKH = new d(AbsoluteSizeSpan.class);
    d<RelativeSizeSpan> zKI = new d(RelativeSizeSpan.class);
    d<BackgroundColorSpan> zKJ = new d(BackgroundColorSpan.class);
    d<ForegroundColorSpan> zKK = new d(ForegroundColorSpan.class);
    d<ClickableSpan> zKL = new d(ClickableSpan.class);
    private float zKM = 0.0f;
    public LinkedList<c> zKN;
    protected boolean[] zKO;
    protected String zKu;
    protected char[] zKv;
    protected float[] zKw;
    protected float[] zKx;
    protected float[] zKy = new float[a.zKo.length];
    protected float[] zKz = new float[a.zKp.length];
    private ArrayList<a> zwZ = new ArrayList();
    private int zxv = 0;

    protected abstract void a(TextPaint textPaint, float f, int i, boolean z);

    public b(CharSequence charSequence, float[] fArr) {
        this.mText = charSequence;
        this.zKu = charSequence.toString();
        this.zKv = this.zKu.toCharArray();
        if (fArr != null) {
            this.zKw = new float[fArr.length];
            System.arraycopy(fArr, 0, this.zKw, 0, fArr.length);
        }
    }

    public final void a(TextPaint textPaint, float f, float f2, float f3, int i, TruncateAt truncateAt, boolean z) {
        int i2;
        this.gu = textPaint;
        this.zKC = f2;
        this.tVN = f;
        this.zxv = i;
        this.zKD = f3;
        this.zKF = null;
        int length = this.mText.length();
        if (this.zKw == null) {
            this.zKw = new float[length];
            textPaint.getTextWidths(this.zKu, this.zKw);
        }
        this.zKO = new boolean[length];
        CharSequence charSequence = this.mText;
        boolean[] zArr = this.zKO;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            int length2 = charSequence.length();
            this.zKG.a(spanned, length2);
            this.zKH.a(spanned, length2);
            this.zKI.a(spanned, length2);
            this.zKK.a(spanned, length2);
            this.zKJ.a(spanned, length2);
            this.zKL.a(spanned, length2);
        }
        this.zKE.set(textPaint);
        for (length2 = 0; length2 < this.zKH.zLi; length2++) {
            ((AbsoluteSizeSpan[]) this.zKH.zLj)[length2].updateMeasureState(this.zKE);
            length = this.zKH.zLk[length2];
            int i3 = this.zKH.zLl[length2];
            int i4 = i3 - length;
            Object obj = new float[i4];
            this.zKE.getTextWidths(charSequence, length, i3, obj);
            System.arraycopy(obj, 0, this.zKw, length, i4);
            if (this.zKx == null) {
                this.zKx = new float[charSequence.length()];
            }
            this.zKx[length] = this.zKE.getTextSize();
        }
        for (length2 = 0; length2 < this.zKI.zLi; length2++) {
            ((RelativeSizeSpan[]) this.zKI.zLj)[length2].updateMeasureState(this.zKE);
            length = this.zKI.zLk[length2];
            i3 = this.zKI.zLl[length2];
            i4 = i3 - length;
            obj = new float[i4];
            this.zKE.getTextWidths(charSequence, length, i3, obj);
            System.arraycopy(obj, 0, this.zKw, length, i4);
            if (this.zKx == null) {
                this.zKx = new float[charSequence.length()];
            }
            this.zKx[length] = this.zKE.getTextSize();
        }
        for (length2 = 0; length2 < this.zKG.zLi; length2++) {
            ImageSpan imageSpan = ((ImageSpan[]) this.zKG.zLj)[length2];
            i3 = this.zKG.zLk[length2];
            i4 = this.zKG.zLl[length2] - i3;
            Drawable drawable = imageSpan.getDrawable();
            Rect rect = new Rect();
            if (drawable != null) {
                rect.set(drawable.getBounds());
            }
            this.zKw[i3] = (float) rect.width();
            zArr[i3] = true;
            for (length = i3 + 1; length < i3 + i4; length++) {
                this.zKw[length] = 0.0f;
                zArr[length] = true;
            }
            if (this.zKx == null) {
                this.zKx = new float[charSequence.length()];
            }
            this.zKx[i3] = (float) rect.height();
        }
        for (i2 = 0; i2 < this.zKJ.zLi; i2++) {
            this.zKB.add(new com.tencent.neattextview.textview.b.a(this.zKJ.zLk[i2], this.zKJ.zLl[i2], ((BackgroundColorSpan[]) this.zKJ.zLj)[i2]));
        }
        for (i2 = 0; i2 < this.zKL.zLi; i2++) {
            this.zKB.add(new c(this.zKL.zLk[i2], this.zKL.zLl[i2], ((ClickableSpan[]) this.zKL.zLj)[i2]));
        }
        c(textPaint);
        a(textPaint, f, i, z);
        if (truncateAt != TruncateAt.MARQUEE) {
            Object obj2 = (this.mText == null || this.zwZ.size() <= 0 || this.mText.length() <= ((a) this.zwZ.get(this.zwZ.size() - 1)).getEnd()) ? null : 1;
            if (obj2 != null) {
                float measureText = textPaint.measureText(zKt);
                length = 0;
                if (this.zxv == 1 && truncateAt == TruncateAt.MIDDLE) {
                    length = cCx();
                } else if (truncateAt == TruncateAt.END) {
                    length = ((a) this.zwZ.get(this.zwZ.size() - 1)).getEnd() - 1;
                }
                this.zKw[length] = measureText;
                this.zKv[length] = zKs[0];
            }
        }
    }

    public final void a(Canvas canvas, float f, float f2) {
        canvas.save();
        canvas.translate(f, f2);
        float f3 = 0.0f;
        Iterator it = this.zKB.iterator();
        while (it.hasNext()) {
            ((com.tencent.neattextview.textview.b.b) it.next()).a(canvas, this.gu, this.zwZ);
        }
        it = this.zwZ.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(canvas, this.gu, f3);
            f3 = aVar.getHeight() + f3;
        }
        canvas.restore();
    }

    protected final void a(char[] cArr, int i, int i2, float f, float[] fArr, float f2, boolean z) {
        FontMetrics fontMetrics = this.gu.getFontMetrics();
        float f3 = fontMetrics.bottom - fontMetrics.top;
        if (this.zKx != null) {
            for (int i3 = i; i3 < i2; i3++) {
                if (f3 < this.zKx[i3]) {
                    f3 = this.zKx[i3];
                }
            }
        }
        float f4 = f3 + this.zKD;
        c cVar = new c(this, cArr, i, i2, this.zKM, fArr, f, f4, f2, this.gu, z);
        this.zKM += f4;
        this.zwZ.add(cVar);
    }

    public final float[] cCv() {
        if (this.zKF == null) {
            Iterator it = this.zwZ.iterator();
            float f = 0.0f;
            float f2 = 0.0f;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (f < aVar.getWidth()) {
                    f = aVar.getWidth();
                }
                f2 = aVar.getHeight() + f2;
            }
            this.zKF = new float[]{f, f2};
        }
        return this.zKF;
    }

    private void c(Paint paint) {
        this.zKA.clear();
        Rect rect = new Rect();
        int i = 0;
        for (char c : a.zKo) {
            float measureText = paint.measureText(String.valueOf(c));
            paint.getTextBounds(String.valueOf(c), 0, 1, rect);
            this.zKy[i] = measureText - ((float) rect.right);
            i++;
        }
        int i2 = 0;
        for (char valueOf : a.zKp) {
            paint.getTextBounds(String.valueOf(valueOf), 0, 1, rect);
            float f = rect.left > 0 ? (float) rect.left : 0.0f;
            this.zKz[i2] = f;
            this.zKA.put(Character.valueOf(a.zKp[i2]), Float.valueOf(f));
            i2++;
        }
    }

    public final HashMap<Character, Float> cCw() {
        return this.zKA;
    }

    private int cCx() {
        float f = 0.0f;
        a aVar = (a) this.zwZ.get(0);
        for (int start = aVar.getStart(); start < aVar.getEnd(); start++) {
            f += this.zKw[start];
            if (f >= this.tVN / 2.0f) {
                return start;
            }
        }
        return 0;
    }
}

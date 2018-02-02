package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.walletlock.a$h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.c;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView extends View {
    private static Bitmap tgM = null;
    private static Bitmap tgN = null;
    private static Bitmap tgO = null;
    private static Bitmap tgP = null;
    private int lXD;
    private Rect tgA = new Rect();
    private Rect tgB = new Rect();
    private ArrayList<f> tgC = new ArrayList(9);
    private boolean[][] tgD = ((boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3}));
    private int tgE = c.the;
    private int tgF = 6;
    private int tgG = 200;
    private float tgH = 0.66f;
    private boolean tgI = false;
    private boolean tgJ = true;
    public boolean tgK = false;
    private b tgL;
    private float tgQ;
    private float tgR;
    private boolean tgS;
    private long tgT;
    private float tgU;
    private float tgV;
    public a tgW;
    private Paint tgw = new Paint();
    private Paint tgx = new Paint();
    private Path tgy = new Path();
    private Matrix tgz = new Matrix();
    private int uo;
    private int uq;

    public PatternLockView(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        if (isInEditMode()) {
            i = -1;
        } else {
            i = getResources().getColor(b.tdZ);
        }
        this.lXD = i;
        this.tgL = b.tgY;
        this.tgQ = -1.0f;
        this.tgR = -1.0f;
        this.tgS = false;
        this.tgT = 0;
        this.uo = 0;
        this.uq = 0;
        this.tgU = 0.0f;
        this.tgV = 0.0f;
        this.tgW = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$h.tfn);
        this.tgJ = obtainStyledAttributes.getBoolean(a$h.tfs, this.tgJ);
        this.tgG = obtainStyledAttributes.getInt(a$h.tfp, this.tgG);
        this.tgF = obtainStyledAttributes.getInt(a$h.tfq, this.tgF);
        this.tgI = obtainStyledAttributes.getBoolean(a$h.tfr, this.tgI);
        switch (obtainStyledAttributes.getInt(a$h.tfo, this.tgE - 1)) {
            case 0:
                this.tgE = c.the;
                break;
            case 1:
                this.tgE = c.thf;
                break;
            default:
                this.tgE = c.the;
                break;
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        this.tgx.setStyle(Style.STROKE);
        this.tgx.setStrokeJoin(Join.ROUND);
        this.tgx.setStrokeCap(Cap.ROUND);
        this.tgx.setAntiAlias(true);
        this.tgx.setDither(false);
        this.tgx.setAlpha(this.tgG);
        this.tgw.setAntiAlias(true);
        this.tgw.setDither(true);
        if (!isInEditMode()) {
            if (tgM == null) {
                tgM = t(a.b(getContext(), c.ted));
                Bitmap t = t(a.b(getContext(), c.tee));
                tgN = t;
                tgO = t;
                tgP = t(a.b(getContext(), c.tef));
            }
            this.tgF = (int) (((float) this.tgF) * d.ceP().density);
            Bitmap[] bitmapArr = new Bitmap[]{tgM, tgN, tgO, tgP};
            for (i = 0; i < 4; i++) {
                Bitmap bitmap = bitmapArr[i];
                this.uo = Math.max(bitmap.getWidth(), this.uo);
                this.uq = Math.max(bitmap.getHeight(), this.uq);
            }
        }
    }

    private static Bitmap t(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static String cj(List<f> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            f fVar = (f) list.get(i);
            bArr[i] = (byte) (fVar.tfS + (fVar.tfR * 3));
        }
        return new String(bArr);
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), cj(this.tgC), this.tgL.ordinal(), this.tgJ, this.tgK, this.tgI);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b bVar = b.tgY;
        String str = savedState.thc;
        if (str == null) {
            throw new IllegalArgumentException("Serialized pattern is null");
        }
        List arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            arrayList.add(f.eb(b / 3, b % 3));
        }
        a(bVar, arrayList);
        this.tgL = b.values()[savedState.thd];
        this.tgJ = savedState.tgJ;
        this.tgK = savedState.tgK;
        this.tgI = savedState.tgI;
    }

    protected int getSuggestedMinimumWidth() {
        return (int) ((3.0d * ((double) ((float) this.uo))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected int getSuggestedMinimumHeight() {
        return (int) ((3.0d * ((double) ((float) this.uq))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.tgU = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.tgV = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
    }

    private static int ec(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int ec = ec(i, suggestedMinimumWidth);
        suggestedMinimumWidth = ec(i2, suggestedMinimumHeight);
        if (this.tgE == c.the) {
            suggestedMinimumWidth = Math.min(ec, suggestedMinimumWidth);
            ec = suggestedMinimumWidth;
        }
        setMeasuredDimension(ec, suggestedMinimumWidth);
    }

    protected void onDraw(Canvas canvas) {
        int elapsedRealtime;
        int i;
        f fVar;
        Object obj;
        ArrayList arrayList = this.tgC;
        int size = arrayList.size();
        boolean[][] zArr = this.tgD;
        if (this.tgL == b.tha) {
            elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.tgT)) % ((size + 1) * 700);
            i = elapsedRealtime / 700;
            bOc();
            for (int i2 = 0; i2 < i; i2++) {
                fVar = (f) arrayList.get(i2);
                zArr[fVar.tfR][fVar.tfS] = true;
            }
            obj = (i <= 0 || i >= size) ? null : 1;
            if (obj != null) {
                float f = ((float) (elapsedRealtime % 700)) / 700.0f;
                fVar = (f) arrayList.get(i - 1);
                float zx = zx(fVar.tfS);
                float zy = zy(fVar.tfR);
                fVar = (f) arrayList.get(i);
                float zx2 = (zx(fVar.tfS) - zx) * f;
                float zy2 = (zy(fVar.tfR) - zy) * f;
                this.tgQ = zx + zx2;
                this.tgR = zy2 + zy;
            }
            invalidate();
        }
        this.tgx.setColor(this.lXD);
        this.tgx.setStrokeWidth((float) this.tgF);
        Path path = this.tgy;
        path.rewind();
        obj = (this.tgJ || this.tgL == b.tgZ) ? 1 : null;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        float f2 = this.tgU;
        float f3 = this.tgV;
        boolean z = (this.tgw.getFlags() & 2) != 0;
        this.tgw.setFilterBitmap(true);
        for (i = 0; i < 3; i++) {
            float f4 = (((float) i) * f3) + ((float) paddingTop);
            for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
                float f5 = ((float) paddingLeft) + (((float) elapsedRealtime) * f2);
                if (!zArr[i][elapsedRealtime]) {
                    a(canvas, (int) f5, (int) f4, zArr[i][elapsedRealtime]);
                }
            }
        }
        if (obj != null) {
            Object obj2 = null;
            for (elapsedRealtime = 0; elapsedRealtime < size; elapsedRealtime++) {
                fVar = (f) arrayList.get(elapsedRealtime);
                if (!zArr[fVar.tfR][fVar.tfS]) {
                    break;
                }
                obj2 = 1;
                f4 = zx(fVar.tfS);
                zy2 = zy(fVar.tfR);
                if (elapsedRealtime == 0) {
                    path.moveTo(f4, zy2);
                } else {
                    path.lineTo(f4, zy2);
                }
            }
            if ((this.tgS || this.tgL == b.tha) && r9 != null) {
                path.lineTo(this.tgQ, this.tgR);
            }
            canvas.drawPath(path, this.tgx);
        }
        for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
            zx2 = (((float) elapsedRealtime) * f3) + ((float) paddingTop);
            for (int i3 = 0; i3 < 3; i3++) {
                float f6 = ((float) paddingLeft) + (((float) i3) * f2);
                if (zArr[elapsedRealtime][i3]) {
                    a(canvas, (int) f6, (int) zx2, zArr[elapsedRealtime][i3]);
                }
            }
        }
        this.tgw.setFilterBitmap(z);
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z || (!this.tgJ && this.tgL != b.tgZ)) {
            bitmap = tgM;
        } else if (this.tgS) {
            bitmap = tgN;
        } else if (this.tgL == b.tgZ) {
            bitmap = tgP;
        } else if (this.tgL == b.tgY || this.tgL == b.tha) {
            bitmap = tgO;
        } else {
            throw new IllegalStateException("unknown display mode " + this.tgL);
        }
        int i3 = this.uo;
        int i4 = this.uq;
        i3 = (int) ((this.tgU - ((float) i3)) * 0.5f);
        i4 = (int) ((this.tgV - ((float) i4)) * 0.5f);
        float f = getResources().getDisplayMetrics().density;
        float min = Math.min((this.tgU - (33.0f * f)) / ((float) this.uo), 1.0f);
        f = Math.min((this.tgV - (f * 33.0f)) / ((float) this.uq), 1.0f);
        this.tgz.setTranslate((float) (i3 + i), (float) (i4 + i2));
        this.tgz.preTranslate((float) (this.uo / 2), (float) (this.uq / 2));
        this.tgz.preScale(min, f);
        this.tgz.preTranslate((float) ((-this.uo) / 2), (float) ((-this.uq) / 2));
        if (!isInEditMode()) {
            canvas.drawBitmap(bitmap, this.tgz, this.tgw);
        }
    }

    private f G(float f, float f2) {
        int i = 0;
        f fVar = null;
        float f3 = this.tgV;
        float f4 = f3 * this.tgH;
        float paddingTop = ((f3 - f4) / 2.0f) + ((float) getPaddingTop());
        int i2 = 0;
        while (i2 < 3) {
            float f5 = (((float) i2) * f3) + paddingTop;
            if (f2 >= f5 && f2 <= f5 + f4) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            f3 = this.tgU;
            f4 = this.tgH * f3;
            paddingTop = ((float) getPaddingLeft()) + ((f3 - f4) / 2.0f);
            while (i < 3) {
                f5 = (((float) i) * f3) + paddingTop;
                if (f >= f5 && f <= f5 + f4) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0 && !this.tgD[i2][i]) {
                fVar = f.eb(i2, i);
            }
        }
        if (fVar == null) {
            return null;
        }
        this.tgD[fVar.tfR][fVar.tfS] = true;
        this.tgC.add(fVar);
        if (this.tgW != null) {
            ArrayList arrayList = new ArrayList(this.tgC);
        }
        if (!this.tgI) {
            return fVar;
        }
        performHapticFeedback(1, 3);
        return fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.tgK || !isEnabled()) {
            return false;
        }
        float x;
        float y;
        float zx;
        float f;
        float f2;
        switch (motionEvent.getAction()) {
            case 0:
                bOd();
                x = motionEvent.getX();
                y = motionEvent.getY();
                f G = G(x, y);
                if (G != null) {
                    this.tgS = true;
                    this.tgL = b.tgY;
                    break;
                }
                this.tgS = false;
                if (G != null) {
                    zx = zx(G.tfS);
                    float zy = zy(G.tfR);
                    f = this.tgU * 0.5f;
                    f2 = this.tgV * 0.5f;
                    invalidate((int) (zx - f), (int) (zy - f2), (int) (zx + f), (int) (zy + f2));
                }
                this.tgQ = x;
                this.tgR = y;
                return true;
            case 1:
                if (!this.tgC.isEmpty()) {
                    this.tgS = false;
                    if (this.tgW != null) {
                        this.tgW.a(this, new ArrayList(this.tgC));
                    }
                    invalidate();
                }
                return true;
            case 2:
                float f3 = (float) this.tgF;
                int historySize = motionEvent.getHistorySize();
                this.tgA.setEmpty();
                Object obj = null;
                int i = 0;
                while (i < historySize + 1) {
                    zx = i < historySize ? motionEvent.getHistoricalX(i) : motionEvent.getX();
                    y = i < historySize ? motionEvent.getHistoricalY(i) : motionEvent.getY();
                    f G2 = G(zx, y);
                    int size = this.tgC.size();
                    if (G2 != null && size == 1) {
                        this.tgS = true;
                    }
                    x = Math.abs(zx - this.tgQ);
                    f2 = Math.abs(y - this.tgR);
                    if (x > 0.0f || f2 > 0.0f) {
                        obj = 1;
                    }
                    if (this.tgS && size > 0) {
                        f fVar = (f) this.tgC.get(size - 1);
                        f = zx(fVar.tfS);
                        float zy2 = zy(fVar.tfR);
                        x = Math.min(f, zx) - f3;
                        f2 = Math.max(f, zx) + f3;
                        zx = Math.min(zy2, y) - f3;
                        f = Math.max(zy2, y) + f3;
                        if (G2 != null) {
                            y = this.tgU * 0.5f;
                            zy2 = this.tgV * 0.5f;
                            float zx2 = zx(G2.tfS);
                            float zy3 = zy(G2.tfR);
                            x = Math.min(zx2 - y, x);
                            f2 = Math.max(y + zx2, f2);
                            y = Math.min(zy3 - zy2, zx);
                            zx = Math.max(zy3 + zy2, f);
                            f = f2;
                        } else {
                            y = zx;
                            zx = f;
                            f = f2;
                        }
                        this.tgA.union(Math.round(x), Math.round(y), Math.round(f), Math.round(zx));
                    }
                    i++;
                }
                this.tgQ = motionEvent.getX();
                if (this.tgQ < ((float) (getPaddingLeft() + this.tgF))) {
                    this.tgQ = (float) (getPaddingLeft() + this.tgF);
                } else if (this.tgQ > ((float) (((getPaddingLeft() + getWidth()) - getPaddingRight()) - this.tgF))) {
                    this.tgQ = (float) (((getPaddingLeft() + getWidth()) - getPaddingRight()) - this.tgF);
                }
                this.tgR = motionEvent.getY();
                if (this.tgR < ((float) (getPaddingTop() + this.tgF))) {
                    this.tgR = (float) (getPaddingTop() + this.tgF);
                } else if (this.tgR > ((float) (((getPaddingTop() + getHeight()) - getPaddingRight()) - this.tgF))) {
                    this.tgR = (float) (((getPaddingTop() + getHeight()) - getPaddingBottom()) - this.tgF);
                }
                if (obj != null) {
                    this.tgB.union(this.tgA);
                    invalidate(this.tgB);
                    this.tgB.set(this.tgA);
                }
                return true;
            case 3:
                if (this.tgS) {
                    this.tgS = false;
                    bOd();
                    if (this.tgW != null) {
                        this.tgW.a(this);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    private void bOc() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.tgD[i][i2] = false;
            }
        }
    }

    private float zx(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.tgU)) + (this.tgU * 0.5f);
    }

    private float zy(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.tgV)) + (this.tgV * 0.5f);
    }

    private void a(b bVar, List<f> list) {
        this.tgC.clear();
        bOc();
        this.tgC.addAll(list);
        Iterator it = this.tgC.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            this.tgD[fVar.tfR][fVar.tfS] = true;
        }
        a(bVar);
    }

    private void bOd() {
        this.tgC.clear();
        bOc();
        this.tgL = b.tgY;
        invalidate();
    }

    public final void bOe() {
        bOd();
        if (this.tgW != null) {
            this.tgW.a(this);
        }
    }

    public final void a(b bVar) {
        switch (1.tgX[bVar.ordinal()]) {
            case 1:
                this.lXD = getResources().getColor(b.tdZ);
                break;
            case 2:
                this.lXD = getResources().getColor(b.tec);
                break;
            case 3:
                if (this.tgC.size() != 0) {
                    this.tgK = false;
                    this.lXD = getResources().getColor(b.tdZ);
                    f fVar = (f) this.tgC.get(0);
                    this.tgQ = zx(fVar.tfS);
                    this.tgR = zy(fVar.tfR);
                    bOc();
                    this.tgT = SystemClock.elapsedRealtime();
                    break;
                }
                throw new IllegalStateException("You should set a pattern before animating.");
        }
        this.tgL = bVar;
        invalidate();
    }
}

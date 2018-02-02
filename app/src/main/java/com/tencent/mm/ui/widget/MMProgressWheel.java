package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.cb.a.j;

public class MMProgressWheel extends View {
    private static final String TAG = MMProgressWheel.class.getSimpleName();
    private final int barLength = 16;
    private float yaa = 0.0f;
    private boolean zuA = true;
    private long zuB = 0;
    private int zuC = -1442840576;
    private int zuD = 16777215;
    private Paint zuE = new Paint();
    private Paint zuF = new Paint();
    private RectF zuG = new RectF();
    private float zuH = 230.0f;
    private long zuI = 0;
    private boolean zuJ;
    private float zuK = 0.0f;
    private boolean zuL = false;
    private a zuM;
    private boolean zuN;
    private final int zur = 270;
    private final long zus = 200;
    private int zut = 28;
    private int zuu = 4;
    private int zuv = 4;
    private boolean zuw = false;
    private double zux = 0.0d;
    private double zuy = 460.0d;
    private float zuz = 0.0f;

    public interface a {
    }

    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.faG);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.zuu = (int) TypedValue.applyDimension(1, (float) this.zuu, displayMetrics);
        this.zuv = (int) TypedValue.applyDimension(1, (float) this.zuv, displayMetrics);
        this.zut = (int) TypedValue.applyDimension(1, (float) this.zut, displayMetrics);
        this.zut = (int) obtainStyledAttributes.getDimension(j.zAD, (float) this.zut);
        this.zuw = obtainStyledAttributes.getBoolean(j.zAE, false);
        this.zuu = (int) obtainStyledAttributes.getDimension(j.zAF, (float) this.zuu);
        this.zuv = (int) obtainStyledAttributes.getDimension(j.zAA, (float) this.zuv);
        this.zuH = obtainStyledAttributes.getFloat(j.zAB, this.zuH / 360.0f) * 360.0f;
        this.zuy = (double) obtainStyledAttributes.getInt(j.zAC, (int) this.zuy);
        this.zuC = obtainStyledAttributes.getColor(j.zAy, this.zuC);
        this.zuD = obtainStyledAttributes.getColor(j.zAz, this.zuD);
        this.zuJ = obtainStyledAttributes.getBoolean(j.zAG, false);
        if (obtainStyledAttributes.getBoolean(j.zAx, false)) {
            this.zuI = SystemClock.uptimeMillis();
            this.zuL = true;
            invalidate();
        }
        obtainStyledAttributes.recycle();
        if ((VERSION.SDK_INT >= 17 ? Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) == 0.0f) {
            z = false;
        }
        this.zuN = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (this.zut + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.zut + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(size, paddingTop);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.zuw) {
            this.zuG = new RectF((float) (paddingLeft + this.zuu), (float) (paddingTop + this.zuu), (float) ((i - paddingRight) - this.zuu), (float) ((i2 - paddingBottom) - this.zuu));
        } else {
            int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.zut * 2) - (this.zuu * 2));
            paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
            paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
            this.zuG = new RectF((float) (this.zuu + paddingLeft), (float) (this.zuu + paddingTop), (float) ((paddingLeft + min) - this.zuu), (float) ((paddingTop + min) - this.zuu));
        }
        this.zuE.setColor(this.zuC);
        this.zuE.setAntiAlias(true);
        this.zuE.setStyle(Style.STROKE);
        this.zuE.setStrokeWidth((float) this.zuu);
        this.zuF.setColor(this.zuD);
        this.zuF.setAntiAlias(true);
        this.zuF.setStyle(Style.STROKE);
        this.zuF.setStrokeWidth((float) this.zuv);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        boolean z = true;
        super.onDraw(canvas);
        canvas.drawArc(this.zuG, 360.0f, 360.0f, false, this.zuF);
        if (this.zuN) {
            float f;
            float cos;
            if (this.zuL) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.zuI;
                f = (((float) uptimeMillis) * this.zuH) / 1000.0f;
                if (this.zuB >= 200) {
                    this.zux = ((double) uptimeMillis) + this.zux;
                    if (this.zux > this.zuy) {
                        this.zux -= this.zuy;
                        this.zuB = 0;
                        this.zuA = !this.zuA;
                    }
                    cos = (((float) Math.cos(((this.zux / this.zuy) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                    if (this.zuA) {
                        this.zuz = cos * 254.0f;
                    } else {
                        cos = (1.0f - cos) * 254.0f;
                        this.yaa += this.zuz - cos;
                        this.zuz = cos;
                    }
                } else {
                    this.zuB = uptimeMillis + this.zuB;
                }
                this.yaa += f;
                if (this.yaa > 360.0f) {
                    this.yaa -= 360.0f;
                }
                this.zuI = SystemClock.uptimeMillis();
                float f2 = this.yaa - 90.0f;
                f = 16.0f + this.zuz;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f = 135.0f;
                }
                canvas.drawArc(this.zuG, f2, f, false, this.zuE);
            } else {
                float f3;
                cos = this.yaa;
                if (this.yaa != this.zuK) {
                    this.yaa = Math.min(((((float) (SystemClock.uptimeMillis() - this.zuI)) / 1000.0f) * this.zuH) + this.yaa, this.zuK);
                    this.zuI = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (!(cos == this.yaa || this.zuM == null)) {
                    Math.round((this.yaa * 100.0f) / 360.0f);
                }
                cos = this.yaa;
                if (this.zuJ) {
                    f3 = 0.0f;
                } else {
                    cos = ((float) (1.0d - Math.pow((double) (1.0f - (this.yaa / 360.0f)), 2.0d))) * 360.0f;
                    f3 = ((float) (1.0d - Math.pow((double) (1.0f - (this.yaa / 360.0f)), 4.0d))) * 360.0f;
                }
                if (isInEditMode()) {
                    f = 360.0f;
                } else {
                    f = cos;
                }
                canvas.drawArc(this.zuG, f3 - 90.0f, f, false, this.zuE);
            }
            if (z) {
                invalidate();
            }
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.zuI = SystemClock.uptimeMillis();
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.yaa = this.yaa;
        wheelSavedState.zuK = this.zuK;
        wheelSavedState.zuL = this.zuL;
        wheelSavedState.zuH = this.zuH;
        wheelSavedState.zuu = this.zuu;
        wheelSavedState.zuC = this.zuC;
        wheelSavedState.zuv = this.zuv;
        wheelSavedState.zuD = this.zuD;
        wheelSavedState.zut = this.zut;
        wheelSavedState.zuJ = this.zuJ;
        wheelSavedState.zuw = this.zuw;
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.yaa = wheelSavedState.yaa;
            this.zuK = wheelSavedState.zuK;
            this.zuL = wheelSavedState.zuL;
            this.zuH = wheelSavedState.zuH;
            this.zuu = wheelSavedState.zuu;
            this.zuC = wheelSavedState.zuC;
            this.zuv = wheelSavedState.zuv;
            this.zuD = wheelSavedState.zuD;
            this.zut = wheelSavedState.zut;
            this.zuJ = wheelSavedState.zuJ;
            this.zuw = wheelSavedState.zuw;
            this.zuI = SystemClock.uptimeMillis();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}

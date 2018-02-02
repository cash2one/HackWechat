package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.m;

public class MMPinProgressBtn extends CompoundButton {
    private Paint De;
    private int sm;
    private int style;
    public int zua;
    private Paint zub;
    private RectF zuc = new RectF();
    private int zud;
    private final float zue = 4.0f;
    private Runnable zuf = new 1(this);

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        Throwable th;
        TypedArray typedArray;
        this.zua = 100;
        this.sm = 0;
        Resources resources = getResources();
        int color = resources.getColor(d.gUC);
        int color2 = resources.getColor(d.gUD);
        if (attributeSet != null) {
            TypedArray typedArray2 = null;
            try {
                typedArray2 = context.obtainStyledAttributes(attributeSet, m.faF, i, 0);
                try {
                    this.zua = typedArray2.getInteger(m.gZg, this.zua);
                    this.sm = typedArray2.getInteger(m.gZf, this.sm);
                    color = typedArray2.getColor(m.gZh, color);
                    color2 = typedArray2.getColor(m.gZi, color2);
                    this.style = typedArray2.getInteger(m.gZk, 0);
                    this.zud = typedArray2.getDimensionPixelSize(m.gZj, resources.getDimensionPixelSize(e.gUO));
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    typedArray = typedArray2;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                typedArray = typedArray2;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
        }
        this.De = new Paint();
        this.De.setColor(color);
        this.De.setStyle(Style.STROKE);
        this.De.setStrokeWidth(4.0f);
        this.De.setAntiAlias(true);
        this.zub = new Paint();
        this.zub.setColor(color2);
        this.zub.setAntiAlias(true);
        setClickable(false);
    }

    public final void setMax(int i) {
        this.zua = Math.max(0, i);
        invalidate();
    }

    public final void setProgress(int i) {
        this.sm = Math.max(0, i);
        this.sm = Math.min(i, this.zua);
        invalidate();
    }

    public final void cyN() {
        removeCallbacks(this.zuf);
        post(this.zuf);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(this.zud, i), resolveSize(this.zud, i2));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.zuc.set(2.0f, 2.0f, ((float) this.zud) - 2.0f, ((float) this.zud) - 2.0f);
        this.zuc.offset((float) ((getWidth() - this.zud) / 2), (float) ((getHeight() - this.zud) / 2));
        canvas.drawArc(this.zuc, 0.0f, 360.0f, true, this.De);
        switch (this.style) {
            case 0:
                this.zuc.set(8.0f, 8.0f, ((float) this.zud) - 8.0f, ((float) this.zud) - 8.0f);
                this.zuc.offset((float) ((getWidth() - this.zud) / 2), (float) ((getHeight() - this.zud) / 2));
                canvas.drawArc(this.zuc, -90.0f, 360.0f * ((((float) this.sm) * 1.0f) / ((float) this.zua)), true, this.zub);
                return;
            case 1:
                this.zuc.set(2.0f, 2.0f, ((float) this.zud) - 2.0f, ((float) this.zud) - 2.0f);
                this.zuc.offset((float) ((getWidth() - this.zud) / 2), (float) ((getHeight() - this.zud) / 2));
                canvas.drawArc(this.zuc, 270.0f, (((((float) this.sm) * 1.0f) / ((float) this.zua)) * 360.0f) - 360.0f, true, this.zub);
                return;
            default:
                return;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (!isSaveEnabled()) {
            return onSaveInstanceState;
        }
        Parcelable savedState = new SavedState(onSaveInstanceState);
        SavedState.a(savedState, this.zua);
        SavedState.b(savedState, this.sm);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.zua = SavedState.a(savedState);
            this.sm = SavedState.b(savedState);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}

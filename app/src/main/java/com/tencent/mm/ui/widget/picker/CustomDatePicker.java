package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.cb.a.d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker extends YADatePicker {
    private boolean kcQ = true;
    private boolean kcR = true;
    private boolean kcS = true;
    private NumberPicker kcT;
    private NumberPicker kcU;
    private NumberPicker kcV;
    private Date kcW;
    private Date kcX;
    private Calendar kcY;
    private String[] kcZ;

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.kcZ = new String[12];
        for (int i = 0; i < this.kcZ.length; i++) {
            this.kcZ[i] = (i + 1);
        }
        this.kcY = Calendar.getInstance(Locale.US);
        czx();
        czy();
        this.kcT = ((YADatePicker$c) getUIDelegate()).zyz;
        this.kcU = ((YADatePicker$c) getUIDelegate()).zyy;
        this.kcV = ((YADatePicker$c) getUIDelegate()).zyx;
        Drawable drawable = getResources().getDrawable(d.zzc);
        c.a(this.kcT, drawable);
        c.a(this.kcU, drawable);
        c.a(this.kcV, drawable);
        c.c(this.kcT);
        c.c(this.kcU);
        c.c(this.kcV);
        OnValueChangeListener 1 = new 1(this);
        if (this.kcT != null) {
            this.kcT.setOnValueChangedListener(1);
            this.kcT.setMinValue(1900);
        }
        if (this.kcU != null) {
            this.kcU.setOnValueChangedListener(1);
        }
        if (this.kcV != null) {
            this.kcV.setOnValueChangedListener(1);
        }
        anG();
        c.e(this.kcT);
        c.e(this.kcU);
        c.e(this.kcV);
    }

    private void anG() {
        int i = 0;
        if (this.kcT != null && this.kcU != null && this.kcV != null) {
            boolean z;
            this.kcU.setDisplayedValues(null);
            if (this.kcT.getValue() != this.kcT.getMaxValue() || this.kcX == null) {
                this.kcU.setMaxValue(11);
                z = false;
            } else {
                this.kcU.setMaxValue(this.kcX.getMonth());
                if (this.kcU.getValue() == this.kcU.getMaxValue() && this.kcX != null) {
                    this.kcV.setMaxValue(this.kcX.getDate());
                    z = true;
                }
                z = false;
            }
            if (!z) {
                this.kcY.set(this.kcT.getValue(), this.kcU.getValue(), 1);
                this.kcV.setMaxValue(this.kcY.getActualMaximum(5));
            }
            if (this.kcT.getValue() != this.kcT.getMinValue() || this.kcW == null) {
                this.kcU.setMinValue(0);
            } else {
                this.kcU.setMinValue(this.kcW.getMonth());
                if (this.kcU.getValue() == this.kcU.getMinValue() && this.kcW != null) {
                    this.kcV.setMinValue(this.kcW.getDate());
                    i = 1;
                }
            }
            if (i == 0) {
                this.kcV.setMinValue(1);
            }
            this.kcU.setDisplayedValues((String[]) Arrays.copyOfRange(this.kcZ, this.kcU.getMinValue(), this.kcU.getMaxValue() + 1));
            this.kcT.setWrapSelectorWheel(true);
            this.kcU.setWrapSelectorWheel(true);
            this.kcV.setWrapSelectorWheel(true);
        }
    }

    public final void setMaxDate(long j) {
        super.setMaxDate(j);
        this.kcX = new Date(j);
        if (this.kcT != null) {
            this.kcT.setMaxValue(this.kcX.getYear() + 1900);
        }
        anG();
    }

    public final void setMinDate(long j) {
        super.setMinDate(j);
        this.kcW = new Date(j);
        if (this.kcT != null) {
            this.kcT.setMinValue(this.kcW.getYear() + 1900);
        }
    }

    public final void a(int i, int i2, int i3, YADatePicker.d dVar) {
        super.a(i, Math.max(i2 - 1, 0), i3, dVar);
        anG();
    }

    public final int getYear() {
        if (this.kcT != null) {
            return this.kcT.getValue();
        }
        return super.getYear();
    }

    public final int getMonth() {
        int value;
        if (this.kcU != null) {
            value = this.kcU.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        return Math.max(Math.min(value, 12), 0);
    }

    public final int getDayOfMonth() {
        if (this.kcV != null) {
            return this.kcV.getValue();
        }
        return super.getDayOfMonth();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.d(this.kcT);
        c.d(this.kcU);
        c.d(this.kcV);
    }
}

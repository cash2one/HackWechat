package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.plugin.appbrand.q$f;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.widget.picker.YADatePicker;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class AppBrandDatePicker extends YADatePicker implements e<String> {
    public boolean kcQ = true;
    public boolean kcR = true;
    public boolean kcS = true;
    public NumberPicker kcT;
    public NumberPicker kcU;
    public NumberPicker kcV;
    private Date kcW;
    private Date kcX;
    private final Calendar kcY;
    private final String[] kcZ = new String[12];

    public final /* synthetic */ Object anJ() {
        if (this.kcS) {
            return String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth())});
        } else if (this.kcR) {
            return String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth())});
        } else {
            return String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(getYear())});
        }
    }

    @Keep
    public AppBrandDatePicker(Context context) {
        super(new ContextThemeWrapper(context, k.iCc));
        for (int i = 0; i < this.kcZ.length; i++) {
            this.kcZ[i] = (i + 1);
        }
        this.kcY = Calendar.getInstance(Locale.US);
        czx();
        czy();
        this.kcT = ((c) getUIDelegate()).zyz;
        this.kcU = ((c) getUIDelegate()).zyy;
        this.kcV = ((c) getUIDelegate()).zyx;
        Drawable drawable = getResources().getDrawable(q$f.iti);
        com.tencent.mm.ui.widget.picker.c.a(this.kcT, drawable);
        com.tencent.mm.ui.widget.picker.c.a(this.kcU, drawable);
        com.tencent.mm.ui.widget.picker.c.a(this.kcV, drawable);
        com.tencent.mm.ui.widget.picker.c.c(this.kcT);
        com.tencent.mm.ui.widget.picker.c.c(this.kcU);
        com.tencent.mm.ui.widget.picker.c.c(this.kcV);
        f.a(this.kcT);
        f.a(this.kcU);
        f.a(this.kcV);
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
        com.tencent.mm.ui.widget.picker.c.e(this.kcT);
        com.tencent.mm.ui.widget.picker.c.e(this.kcU);
        com.tencent.mm.ui.widget.picker.c.e(this.kcV);
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
    }

    public final void setMinDate(long j) {
        super.setMinDate(j);
        this.kcW = new Date(j);
        if (this.kcT != null) {
            this.kcT.setMinValue(this.kcW.getYear() + 1900);
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.mm.ui.widget.picker.c.d(this.kcT);
        com.tencent.mm.ui.widget.picker.c.d(this.kcU);
        com.tencent.mm.ui.widget.picker.c.d(this.kcV);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
        anG();
    }

    public final void anH() {
    }

    public final void b(d dVar) {
    }

    public final void anI() {
    }

    public final void a(int i, int i2, int i3, d dVar) {
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
}

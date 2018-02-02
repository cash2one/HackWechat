package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.widget.picker.c;

public class AppBrandOptionsPicker extends NumberPicker implements e<String> {
    private int KD;
    private int iX;
    private String[] kdi;
    private int kdj;

    public final /* synthetic */ Object anJ() {
        return anL();
    }

    @Keep
    public AppBrandOptionsPicker(Context context) {
        super(new ContextThemeWrapper(context, k.iCc));
        c.a(this, getResources().getDrawable(f.iti));
        c.c(this);
        c.e(this);
        f.a(this);
        this.KD = a.fromDPToPix(context, 100);
        this.kdj = a.fromDPToPix(context, 20);
    }

    public final void j(String[] strArr) {
        if (strArr != null) {
            this.kdi = strArr;
            setDisplayedValues(null);
            setMinValue(0);
            setMaxValue(Math.max(strArr.length - 1, 0));
            if (strArr.length <= 0) {
                strArr = null;
            }
            super.setDisplayedValues(strArr);
        }
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        super.setDisplayedValues(strArr);
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE || MeasureSpec.getMode(i) == 1073741824) {
            this.iX = MeasureSpec.getSize(i);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(0, 0), i2);
        if (getMeasuredWidth() > this.KD || (this.iX > 0 && this.KD > this.iX)) {
            int measuredWidth = getMeasuredWidth() + (this.kdj * 2);
            if (this.iX > 0 && this.iX <= measuredWidth) {
                measuredWidth = this.iX;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            return;
        }
        setMeasuredDimension(this.KD, getMeasuredHeight());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.d(this);
    }

    public final String anL() {
        return (this.kdi == null || this.kdi.length <= 0) ? "" : this.kdi[getValue()];
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void anH() {
    }

    public final void b(d dVar) {
    }

    public final void anI() {
    }
}

package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.bv.a;
import com.tencent.mm.cb.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class OptionPicker extends NumberPicker {
    public int KD;
    private int iX;
    String[] kdi;
    private int kdj;
    private Context mContext;

    public OptionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public OptionPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        this.KD = a.fromDPToPix(this.mContext, 120);
        this.kdj = a.fromDPToPix(this.mContext, 20);
        b(this, getResources().getDrawable(d.zzc));
        setDescendantFocusability(393216);
    }

    private static boolean b(NumberPicker numberPicker, Drawable drawable) {
        Field[] declaredFields = NumberPicker.class.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(numberPicker, drawable);
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMoptionPicker", e, "", new Object[0]);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    public final void j(String[] strArr) {
        if (strArr != null) {
            this.kdi = strArr;
            setDisplayedValues(null);
            setMinValue(0);
            setMaxValue(Math.max(strArr.length - 1, 0));
            setWrapSelectorWheel(false);
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
    }
}

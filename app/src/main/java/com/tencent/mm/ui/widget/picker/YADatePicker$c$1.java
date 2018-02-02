package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;

class YADatePicker$c$1 implements OnValueChangeListener {
    final /* synthetic */ c zyK;

    YADatePicker$c$1(c cVar) {
        this.zyK = cVar;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        c.a(this.zyK);
        this.zyK.kcY.setTimeInMillis(this.zyK.zyI.getTimeInMillis());
        if (numberPicker == this.zyK.zyx) {
            int actualMaximum = this.zyK.kcY.getActualMaximum(5);
            if (i == actualMaximum && i2 == 1) {
                this.zyK.kcY.add(5, 1);
            } else if (i == 1 && i2 == actualMaximum) {
                this.zyK.kcY.add(5, -1);
            } else {
                this.zyK.kcY.add(5, i2 - i);
            }
        } else if (numberPicker == this.zyK.zyy) {
            if (i == 11 && i2 == 0) {
                this.zyK.kcY.add(2, 1);
            } else if (i == 0 && i2 == 11) {
                this.zyK.kcY.add(2, -1);
            } else {
                this.zyK.kcY.add(2, i2 - i);
            }
        } else if (numberPicker == this.zyK.zyz) {
            this.zyK.kcY.set(1, i2);
        } else {
            throw new IllegalArgumentException();
        }
        this.zyK.am(this.zyK.kcY.get(1), this.zyK.kcY.get(2), this.zyK.kcY.get(5));
        this.zyK.czB();
        this.zyK.czC();
        c.b(this.zyK);
    }
}

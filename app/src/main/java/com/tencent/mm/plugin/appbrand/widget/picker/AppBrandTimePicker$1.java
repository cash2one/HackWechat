package com.tencent.mm.plugin.appbrand.widget.picker;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

class AppBrandTimePicker$1 implements OnValueChangeListener {
    final /* synthetic */ AppBrandTimePicker kdw;

    AppBrandTimePicker$1(AppBrandTimePicker appBrandTimePicker) {
        this.kdw = appBrandTimePicker;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        AppBrandTimePicker.a(this.kdw);
    }
}

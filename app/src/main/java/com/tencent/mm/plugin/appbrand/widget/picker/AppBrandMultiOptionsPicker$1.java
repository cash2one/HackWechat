package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.mm.plugin.appbrand.q.g;

class AppBrandMultiOptionsPicker$1 implements YANumberPicker$a {
    final /* synthetic */ AppBrandMultiOptionsPicker kdf;

    AppBrandMultiOptionsPicker$1(AppBrandMultiOptionsPicker appBrandMultiOptionsPicker) {
        this.kdf = appBrandMultiOptionsPicker;
    }

    public final void a(YANumberPicker yANumberPicker, int i) {
        if (AppBrandMultiOptionsPicker.a(this.kdf) != null) {
            int intValue = ((Integer) yANumberPicker.getTag(g.iuw)).intValue();
            d a = AppBrandMultiOptionsPicker.a(this.kdf);
            Object obj = new int[]{intValue, i};
            if (a.kdr != null) {
                a.kdr.bd(obj);
            }
        }
    }
}

package com.tencent.mm.plugin.appbrand.widget.picker;

public final class AppBrandMultiOptionsPicker$a {
    public final String[] kdg;
    public final int kdh;

    public AppBrandMultiOptionsPicker$a(String[] strArr, int i) {
        this.kdg = strArr;
        this.kdh = Math.max(0, Math.min(i, strArr.length - 1));
    }
}

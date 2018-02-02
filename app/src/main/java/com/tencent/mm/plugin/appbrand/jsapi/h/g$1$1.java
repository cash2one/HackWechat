package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.h.g.1;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker$a;
import com.tencent.mm.sdk.platformtools.bh;

class g$1$1 implements Runnable {
    final /* synthetic */ int jpB;
    final /* synthetic */ AppBrandMultiOptionsPicker$a jpC;
    final /* synthetic */ 1 jpD;

    g$1$1(1 1, int i, AppBrandMultiOptionsPicker$a appBrandMultiOptionsPicker$a) {
        this.jpD = 1;
        this.jpB = i;
        this.jpC = appBrandMultiOptionsPicker$a;
    }

    public final void run() {
        AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) 1.a(this.jpD, AppBrandMultiOptionsPicker.class);
        if (appBrandMultiOptionsPicker == null) {
            this.jpD.f("fail picker not exists", null);
            return;
        }
        int i = this.jpB;
        AppBrandMultiOptionsPicker$a appBrandMultiOptionsPicker$a = this.jpC;
        if (i >= 0 && i < appBrandMultiOptionsPicker.anK() && appBrandMultiOptionsPicker$a != null) {
            appBrandMultiOptionsPicker.R(true);
            appBrandMultiOptionsPicker.ml(i).j(appBrandMultiOptionsPicker$a.kdg);
            if (!bh.G(appBrandMultiOptionsPicker$a.kdg)) {
                appBrandMultiOptionsPicker.ml(i).setValue(appBrandMultiOptionsPicker$a.kdh);
            }
            appBrandMultiOptionsPicker.R(false);
        }
        this.jpD.f("ok", null);
    }
}

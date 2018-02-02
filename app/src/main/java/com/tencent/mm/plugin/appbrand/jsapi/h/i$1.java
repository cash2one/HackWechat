package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.plugin.appbrand.widget.picker.g;

class i$1 implements Runnable {
    final /* synthetic */ i jpP;

    i$1(i iVar) {
        this.jpP = iVar;
    }

    public final void run() {
        b bVar = this.jpP;
        AppBrandTimePicker appBrandTimePicker = (AppBrandTimePicker) bVar.y(AppBrandTimePicker.class);
        if (appBrandTimePicker == null) {
            bVar.f("fail cant init view", null);
            return;
        }
        d dVar = bVar.kcP;
        int i = bVar.jpJ;
        int i2 = bVar.jpK;
        appBrandTimePicker.jpJ = i;
        appBrandTimePicker.jpK = i2;
        if (g.mo(appBrandTimePicker.jpJ) && appBrandTimePicker.kdu != null) {
            appBrandTimePicker.kdu.setMinValue(appBrandTimePicker.jpJ);
        }
        i = bVar.jpL;
        i2 = bVar.jpM;
        appBrandTimePicker.jpL = i;
        appBrandTimePicker.jpM = i2;
        if (g.mo(appBrandTimePicker.jpL) && appBrandTimePicker.kdu != null) {
            appBrandTimePicker.kdu.setMaxValue(appBrandTimePicker.jpL);
        }
        i = bVar.jpN;
        i2 = bVar.jpO;
        if (g.mo(i) && g.mn(i2)) {
            appBrandTimePicker.setCurrentHour(Integer.valueOf(i));
            appBrandTimePicker.setCurrentMinute(Integer.valueOf(i2));
        }
        appBrandTimePicker.anN();
        dVar.kdp = new i$2(bVar);
        dVar.show();
    }
}

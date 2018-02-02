package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.widget.NumberPicker;
import com.tencent.mm.plugin.appbrand.jsapi.h.a.2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d;

class a$1 implements Runnable {
    final /* synthetic */ a jpp;

    a$1(a aVar) {
        this.jpp = aVar;
    }

    public final void run() {
        boolean z = true;
        int i = 0;
        b bVar = this.jpp;
        AppBrandDatePicker appBrandDatePicker = (AppBrandDatePicker) bVar.y(AppBrandDatePicker.class);
        if (appBrandDatePicker == null) {
            bVar.f("fail cant init view", null);
            return;
        }
        d dVar = bVar.kcP;
        dVar.kdp = new 2(bVar);
        appBrandDatePicker.a(bVar.jpm, bVar.jpn, bVar.jpo, null);
        if (bVar.jpk != null) {
            appBrandDatePicker.setMinDate(bVar.jpk.longValue());
        }
        if (bVar.jpl != null) {
            appBrandDatePicker.setMaxDate(bVar.jpl.longValue());
        }
        boolean z2 = bVar.jpj.ordinal() >= a$a.YEAR.ordinal();
        boolean z3 = bVar.jpj.ordinal() >= a$a.MONTH.ordinal();
        if (bVar.jpj.ordinal() < a$a.DAY.ordinal()) {
            z = false;
        }
        appBrandDatePicker.kcQ = z2;
        appBrandDatePicker.kcR = z3;
        appBrandDatePicker.kcS = z;
        if (appBrandDatePicker.kcT != null) {
            appBrandDatePicker.kcT.setEnabled(z2);
            appBrandDatePicker.kcT.setVisibility(z2 ? 0 : 8);
        }
        if (appBrandDatePicker.kcU != null) {
            appBrandDatePicker.kcU.setEnabled(z3);
            appBrandDatePicker.kcU.setVisibility(z3 ? 0 : 8);
        }
        if (appBrandDatePicker.kcV != null) {
            appBrandDatePicker.kcV.setEnabled(z);
            NumberPicker numberPicker = appBrandDatePicker.kcV;
            if (!z) {
                i = 8;
            }
            numberPicker.setVisibility(i);
        }
        dVar.show();
    }
}

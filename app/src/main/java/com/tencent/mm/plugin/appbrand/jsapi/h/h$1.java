package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.h.h.3;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d;

class h$1 implements Runnable {
    final /* synthetic */ String[] jpE;
    final /* synthetic */ int jpF;
    final /* synthetic */ h jpG;

    h$1(h hVar, String[] strArr, int i) {
        this.jpG = hVar;
        this.jpE = strArr;
        this.jpF = i;
    }

    public final void run() {
        b bVar = this.jpG;
        String[] strArr = this.jpE;
        int i = this.jpF;
        AppBrandOptionsPicker appBrandOptionsPicker = (AppBrandOptionsPicker) bVar.y(AppBrandOptionsPicker.class);
        if (appBrandOptionsPicker == null) {
            bVar.f("fail cant init view", null);
            return;
        }
        d dVar = bVar.kcP;
        dVar.post(new h$2(bVar, dVar));
        appBrandOptionsPicker.j(strArr);
        appBrandOptionsPicker.setValue(i);
        dVar.kdp = new 3(bVar, dVar, appBrandOptionsPicker);
        dVar.show();
    }
}

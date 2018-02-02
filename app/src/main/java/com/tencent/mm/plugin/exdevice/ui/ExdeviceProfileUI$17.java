package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.k;

class ExdeviceProfileUI$17 implements b<k> {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$17(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        k kVar2 = (k) kVar;
        if (i == 0 && i2 == 0) {
            ExdeviceProfileUI.d(this.lVZ, kVar2.lPz);
            ExdeviceProfileUI.e(this.lVZ, kVar2.lPx);
            ExdeviceProfileUI.f(this.lVZ, kVar2.lPy);
            this.lVZ.runOnUiThread(new 1(this));
            ExdeviceProfileUI.E(this.lVZ);
        }
    }
}

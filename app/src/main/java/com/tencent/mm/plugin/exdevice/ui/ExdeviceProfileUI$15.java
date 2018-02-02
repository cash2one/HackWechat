package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.g;

class ExdeviceProfileUI$15 implements b<g> {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$15(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            ExdeviceProfileUI.m(this.lVZ);
            ExdeviceProfileUI.b(this.lVZ);
            this.lVZ.runOnUiThread(new 1(this));
        }
    }
}

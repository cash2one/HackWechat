package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ae.k;

class ExdeviceBindDeviceUI$8 implements Runnable {
    final /* synthetic */ ExdeviceBindDeviceUI lSF;
    final /* synthetic */ int lSI;
    final /* synthetic */ int lSJ;
    final /* synthetic */ String lSK;
    final /* synthetic */ k lSL;

    ExdeviceBindDeviceUI$8(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, k kVar) {
        this.lSF = exdeviceBindDeviceUI;
        this.lSI = i;
        this.lSJ = i2;
        this.lSK = str;
        this.lSL = kVar;
    }

    public final void run() {
        ExdeviceBindDeviceUI.a(this.lSF, this.lSI, this.lSJ, this.lSK, this.lSL);
    }
}

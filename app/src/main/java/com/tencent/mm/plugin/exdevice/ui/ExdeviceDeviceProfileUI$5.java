package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ui.base.h;

class ExdeviceDeviceProfileUI$5 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$5(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI, k kVar) {
        this.lUq = exdeviceDeviceProfileUI;
        this.flZ = kVar;
    }

    public final void run() {
        ExdeviceDeviceProfileUI.a(this.lUq, h.a(this.lUq.mController.xIM, this.lUq.getString(R.l.dHc), true, new 1(this)));
    }
}

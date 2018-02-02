package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ExdeviceDeviceProfileUI$3 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$3(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final void run() {
        h.b(this.lUq, this.lUq.getString(R.l.ecv), this.lUq.getString(R.l.dGO), true);
    }
}

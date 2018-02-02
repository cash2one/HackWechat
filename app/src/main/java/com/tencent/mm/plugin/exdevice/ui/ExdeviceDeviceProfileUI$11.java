package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceDeviceProfileUI$11 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$11(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final void run() {
        ExdeviceDeviceProfileUI.a(this.lUq, true);
        ExdeviceDeviceProfileUI.f(this.lUq);
        this.lUq.yjd.notifyDataSetChanged();
    }
}

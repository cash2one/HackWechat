package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceDeviceProfileUI$2 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$2(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final void run() {
        if (ExdeviceDeviceProfileUI.g(this.lUq) != null && ExdeviceDeviceProfileUI.g(this.lUq).isShowing()) {
            ExdeviceDeviceProfileUI.g(this.lUq).dismiss();
        }
        if (ExdeviceDeviceProfileUI.h(this.lUq) != null && ExdeviceDeviceProfileUI.h(this.lUq).isShowing()) {
            ExdeviceDeviceProfileUI.h(this.lUq).dismiss();
        }
    }
}

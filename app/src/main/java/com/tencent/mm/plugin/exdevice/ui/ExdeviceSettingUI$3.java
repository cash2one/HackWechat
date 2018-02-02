package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceSettingUI$3 implements Runnable {
    final /* synthetic */ ExdeviceSettingUI lXC;

    ExdeviceSettingUI$3(ExdeviceSettingUI exdeviceSettingUI) {
        this.lXC = exdeviceSettingUI;
    }

    public final void run() {
        ExdeviceSettingUI.a(this.lXC).dismiss();
    }
}

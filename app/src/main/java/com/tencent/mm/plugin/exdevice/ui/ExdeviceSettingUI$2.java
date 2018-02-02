package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceSettingUI$2 implements Runnable {
    final /* synthetic */ ExdeviceSettingUI lXC;

    ExdeviceSettingUI$2(ExdeviceSettingUI exdeviceSettingUI) {
        this.lXC = exdeviceSettingUI;
    }

    public final void run() {
        ExdeviceSettingUI.a(this.lXC).dismiss();
    }
}

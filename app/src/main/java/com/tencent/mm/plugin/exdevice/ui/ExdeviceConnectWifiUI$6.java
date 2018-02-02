package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceConnectWifiUI$6 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$6(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final void run() {
        if (ExdeviceConnectWifiUI.g(this.lTI) != null && ExdeviceConnectWifiUI.g(this.lTI).isShowing()) {
            ExdeviceConnectWifiUI.g(this.lTI).dismiss();
        }
    }
}

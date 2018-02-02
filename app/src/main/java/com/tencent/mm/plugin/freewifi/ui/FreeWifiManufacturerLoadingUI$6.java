package com.tencent.mm.plugin.freewifi.ui;

class FreeWifiManufacturerLoadingUI$6 implements Runnable {
    final /* synthetic */ FreeWifiManufacturerLoadingUI mHX;

    FreeWifiManufacturerLoadingUI$6(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        this.mHX = freeWifiManufacturerLoadingUI;
    }

    public final void run() {
        FreeWifiManufacturerLoadingUI.d(this.mHX).setVisibility(0);
    }
}

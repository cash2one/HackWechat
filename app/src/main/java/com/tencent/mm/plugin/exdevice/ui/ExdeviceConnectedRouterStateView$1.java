package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceConnectedRouterStateView$1 implements Runnable {
    final /* synthetic */ ExdeviceConnectedRouterStateView lUi;

    ExdeviceConnectedRouterStateView$1(ExdeviceConnectedRouterStateView exdeviceConnectedRouterStateView) {
        this.lUi = exdeviceConnectedRouterStateView;
    }

    public final void run() {
        this.lUi.invalidate();
    }
}

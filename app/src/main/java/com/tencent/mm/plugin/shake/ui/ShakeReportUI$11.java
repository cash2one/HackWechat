package com.tencent.mm.plugin.shake.ui;

class ShakeReportUI$11 implements Runnable {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$11(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void run() {
        if (ShakeReportUI.p(this.qsi) != null) {
            ShakeReportUI.p(this.qsi).setVisibility(8);
        }
    }
}

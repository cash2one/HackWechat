package com.tencent.mm.plugin.shake.ui;

class ShakeReportUI$13 implements Runnable {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$13(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void run() {
        if (ShakeReportUI.D(this.qsi) != null) {
            ShakeReportUI.D(this.qsi).setVisibility(8);
        }
        if (ShakeReportUI.E(this.qsi) != null) {
            ShakeReportUI.E(this.qsi).setVisibility(8);
        }
        if (ShakeReportUI.F(this.qsi) != null) {
            ShakeReportUI.F(this.qsi).setVisibility(0);
        }
        if (!ShakeReportUI.G(this.qsi) && !ShakeReportUI.A(this.qsi)) {
            ShakeReportUI.H(this.qsi);
        }
    }
}

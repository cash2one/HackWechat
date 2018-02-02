package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.1;

class ExdeviceConnectedRouterActivateStateUI$1$1 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ 1 lUe;

    ExdeviceConnectedRouterActivateStateUI$1$1(1 1, int i, int i2) {
        this.lUe = 1;
        this.fmb = i;
        this.fma = i2;
    }

    public final void run() {
        if (this.fmb == 0 && (this.fma == 0 || this.fma == 4)) {
            this.lUe.lUd.pi(2);
        } else if (this.fma != 4) {
            this.lUe.lUd.pi(4);
        } else if (this.fmb == 90000) {
            this.lUe.lUd.pi(3);
        } else {
            this.lUe.lUd.pi(5);
        }
    }
}

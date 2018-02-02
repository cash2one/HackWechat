package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.1;

class ExdeviceProfileUI$1$3 implements Runnable {
    final /* synthetic */ 1 lWb;

    ExdeviceProfileUI$1$3(1 1) {
        this.lWb = 1;
    }

    public final void run() {
        ExdeviceProfileUI.k(this.lWb.lVZ);
        ExdeviceProfileUI.l(this.lWb.lVZ).notifyDataSetChanged();
    }
}

package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceProfileUI$3 implements Runnable {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$3(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final void run() {
        ExdeviceProfileUI.g(this.lVZ);
        ExdeviceProfileUI.l(this.lVZ).notifyDataSetChanged();
    }
}

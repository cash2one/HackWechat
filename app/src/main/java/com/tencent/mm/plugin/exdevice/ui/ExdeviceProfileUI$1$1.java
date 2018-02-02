package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.1;

class ExdeviceProfileUI$1$1 implements Runnable {
    final /* synthetic */ i lWa;
    final /* synthetic */ 1 lWb;

    ExdeviceProfileUI$1$1(1 1, i iVar) {
        this.lWb = 1;
        this.lWa = iVar;
    }

    public final void run() {
        if (ExdeviceProfileUI.d(this.lWb.lVZ) != null) {
            ExdeviceProfileUI.d(this.lWb.lVZ).dismiss();
        }
        ExdeviceProfileUI.a(this.lWb.lVZ, this.lWa.lPc);
        ExdeviceProfileUI.f(this.lWb.lVZ).v(ExdeviceProfileUI.e(this.lWb.lVZ));
    }
}

package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;

class ExdeviceManageDeviceUI$a$6 implements Runnable {
    final /* synthetic */ a lUT;

    ExdeviceManageDeviceUI$a$6(a aVar) {
        this.lUT = aVar;
    }

    public final void run() {
        a.a(this.lUT).remove(a.d(this.lUT));
        this.lUT.notifyDataSetChanged();
        a.a(this.lUT, -1);
    }
}

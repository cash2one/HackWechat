package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.z.ar;

class ExdeviceManageDeviceUI$a$4 implements Runnable {
    final /* synthetic */ a lUT;
    final /* synthetic */ b lUU;

    ExdeviceManageDeviceUI$a$4(a aVar, b bVar) {
        this.lUT = aVar;
        this.lUU = bVar;
    }

    public final void run() {
        ajr com_tencent_mm_protocal_c_ajr = new ajr();
        com_tencent_mm_protocal_c_ajr.ksX = this.lUU.field_deviceID;
        com_tencent_mm_protocal_c_ajr.vJA = this.lUU.field_deviceType;
        ar.CG().a(new x(com_tencent_mm_protocal_c_ajr, 2), 0);
    }
}

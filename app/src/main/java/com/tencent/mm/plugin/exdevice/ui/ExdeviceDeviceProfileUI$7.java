package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.z.ar;

class ExdeviceDeviceProfileUI$7 implements b {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$7(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final boolean v(CharSequence charSequence) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[]{charSequence});
        String str = "";
        if (charSequence != null) {
            str = charSequence.toString();
        }
        if (ExdeviceDeviceProfileUI.a(this.lUq)) {
            ExdeviceDeviceProfileUI.a(this.lUq, str);
            this.lUq.runOnUiThread(new 1(this));
            c co = ad.aEk().co(ExdeviceDeviceProfileUI.b(this.lUq), ExdeviceDeviceProfileUI.c(this.lUq));
            if (co == null) {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[]{ExdeviceDeviceProfileUI.b(this.lUq), ExdeviceDeviceProfileUI.c(this.lUq)});
                return false;
            }
            co.cZ(ExdeviceDeviceProfileUI.d(this.lUq));
            ad.aEk().c(co, new String[0]);
        } else {
            k yVar = new y(ExdeviceDeviceProfileUI.b(this.lUq), ExdeviceDeviceProfileUI.c(this.lUq), str);
            ExdeviceDeviceProfileUI.a(this.lUq, yVar);
            ar.CG().a(1263, this.lUq);
            ar.CG().a(yVar, 0);
        }
        return true;
    }
}

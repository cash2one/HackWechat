package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$9 implements a {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$9(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final void e(int i, Object... objArr) {
        if (i == 0 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer)) {
            int intValue = ((Integer) objArr[0]).intValue();
            int intValue2 = ((Integer) objArr[1]).intValue();
            if (ExdeviceConnectWifiUI.f(this.lTI).isHeld()) {
                ExdeviceConnectWifiUI.f(this.lTI).release();
            }
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)});
            if (intValue == 0 && intValue2 == 0) {
                ag.y(new 1(this));
            } else {
                this.lTI.runOnUiThread(new 2(this));
            }
        }
    }
}

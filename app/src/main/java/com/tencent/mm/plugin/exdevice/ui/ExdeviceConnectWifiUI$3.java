package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ExdeviceConnectWifiUI$3 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI lTI;

    ExdeviceConnectWifiUI$3(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.lTI = exdeviceConnectWifiUI;
    }

    public final void run() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            byte[] e = e.e(stringBuilder.append(c.FC()).append("exdevice_wifi_infos").toString(), 0, Integer.MAX_VALUE);
            if (e != null) {
                ExdeviceConnectWifiUI.o(this.lTI).aF(e);
                ExdeviceConnectWifiUI.p(this.lTI);
            }
        } catch (Throwable e2) {
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e2, "", new Object[0]);
        }
        ag.h(new 1(this), 500);
    }
}

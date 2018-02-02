package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$19 extends c<dc> {
    final /* synthetic */ e lLO;

    e$19(e eVar) {
        this.lLO = eVar;
        this.xen = dc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dc dcVar = (dc) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", Boolean.valueOf(dcVar.frx.fro));
        if (dcVar.frx.fro) {
            String ssid = an.getWifiInfo(ac.getContext()).getSSID();
            if (!bh.ov(ssid)) {
                dcVar.fry.frp = true;
                dcVar.fry.frz = ssid.replaceAll("\"", "");
                return true;
            }
        }
        dcVar.fry.frp = false;
        dcVar.fry.frz = null;
        return true;
    }
}

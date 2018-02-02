package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cy;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$5 extends c<cy> {
    final /* synthetic */ e lLO;

    e$5(e eVar) {
        this.lLO = eVar;
        this.xen = cy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        cy cyVar = (cy) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{cyVar.frl.frn, cyVar.frl.ffq, Boolean.valueOf(cyVar.frl.fro)});
        String str = cyVar.frl.frn;
        String str2 = cyVar.frl.ffq;
        boolean z2 = cyVar.frl.fro;
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", new Object[]{str, str2, Boolean.valueOf(z2)});
        } else {
            com.tencent.mm.plugin.exdevice.h.b zg = ad.aEk().zg(str2);
            if (zg == null) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{str2});
            } else if (!zg.field_brandName.equals(str)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{zg.field_brandName, str});
            } else if (bh.ou(zg.field_connProto).contains("4")) {
                e.c(str, zg.field_url, -1, zg.field_deviceType);
                e.bg(str, -1);
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
            } else if (a.arv()) {
                e.bg(str, -1);
                int a = e.a(zg);
                if (a == 1) {
                    if (!a.art()) {
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                    }
                } else if (a == 0 && !a.co(ac.getContext())) {
                    e.bg(str, 1);
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                }
                if (z2) {
                    if (aa.aEh().lMx) {
                        aa.aEh().pb(a);
                    }
                    d aEr = ad.aEr();
                    if (!(aEr.lKF == null || aEr.lKF.size() == 0)) {
                        aEr.lKF.clear();
                    }
                    ad.aEr().a(zg.field_brandName, zg.field_mac, a);
                } else {
                    ad.aEr();
                    d.cn(zg.field_mac);
                }
                z = true;
            } else {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                e.bg(str, 0);
            }
        }
        cyVar.frm.frp = z;
        return z;
    }
}

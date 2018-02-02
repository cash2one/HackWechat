package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cv;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class d$10 extends w {
    final /* synthetic */ d lKJ;

    d$10(d dVar) {
        this.lKJ = dVar;
    }

    public final void a(long j, int i, int i2, int i3, long j2) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[]{b.cK(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (ac.getContext() == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            return;
        }
        if (4 == i2) {
            u.aEL().cC(j);
            long[] ze = a.ze("shut_down_device");
            if (!(ze == null || ze.length == 0)) {
                for (long j3 : ze) {
                    if (j3 == j) {
                        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[]{Long.valueOf(j3)});
                        d.cn(j3);
                        if (!a.z("shut_down_device", j3)) {
                            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                        }
                    }
                }
            }
            if (d.e(this.lKJ).get(Long.valueOf(j)) != null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[]{d.e(this.lKJ).get(Long.valueOf(j))});
                com.tencent.mm.sdk.b.b cvVar = new cv();
                com.tencent.mm.sdk.b.a.xef.m(cvVar);
                if (!(cvVar.frd.fhw && (((Integer) d.e(this.lKJ).get(Long.valueOf(j))).intValue() & 1) == 1)) {
                    d.cn(j);
                }
            } else {
                d.cn(j);
            }
        }
        if (i != i2) {
            com.tencent.mm.plugin.exdevice.h.b zf = ad.aEk().zf(String.valueOf(j));
            if (zf == null || bh.ov(zf.field_brandName)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[]{Long.valueOf(j)});
                return;
            }
            f.a cz = u.aEL().cz(j);
            if (cz != null) {
                cz.fsg = i2;
            } else {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[]{Long.valueOf(j)});
            }
            if (i2 == 2) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                return;
            }
            ad.aEv();
            e.c(zf.field_brandName, zf.field_url, i2, zf.field_deviceID);
        }
    }
}

package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class d$9 implements a {
    final /* synthetic */ d lKJ;
    final /* synthetic */ String lKQ;
    final /* synthetic */ long lKR;
    final /* synthetic */ int lKS;

    d$9(d dVar, long j, String str, int i) {
        this.lKJ = dVar;
        this.lKR = j;
        this.lKQ = str;
        this.lKS = i;
    }

    public final boolean uF() {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{this.lKQ, Long.valueOf(this.lKR), Integer.valueOf(this.lKS), Integer.valueOf(u.aEL().cy(this.lKR))});
        if (u.aEL().cy(this.lKR) != 2) {
            ad.aEv();
            e.bg(this.lKQ, 2);
        }
        d.d(this.lKJ).remove(Long.valueOf(this.lKR));
        return false;
    }
}

package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class d$8 implements a {
    final /* synthetic */ d lKJ;
    final /* synthetic */ String lKQ;
    final /* synthetic */ long lKR;
    final /* synthetic */ int lKS;

    d$8(d dVar, long j, String str, int i) {
        this.lKJ = dVar;
        this.lKR = j;
        this.lKQ = str;
        this.lKS = i;
    }

    public final boolean uF() {
        int cy = u.aEL().cy(this.lKR);
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{this.lKQ, Long.valueOf(this.lKR), Integer.valueOf(this.lKS), Integer.valueOf(cy)});
        d.cn(this.lKR);
        d.c(this.lKJ).remove(Long.valueOf(this.lKR));
        return false;
    }
}

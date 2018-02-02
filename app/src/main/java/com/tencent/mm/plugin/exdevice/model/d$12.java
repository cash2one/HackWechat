package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

class d$12 extends a {
    final /* synthetic */ d lKJ;
    final /* synthetic */ int lKT;

    d$12(d dVar, int i, int i2) {
        this.lKJ = dVar;
        this.lKT = i2;
        super(i);
    }

    public final void onServiceConnected() {
        if (!u.aEM().lKw.b(this.lKT, d.f(this.lKJ))) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}

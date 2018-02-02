package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends c$a {
    final /* synthetic */ d lKJ;
    final /* synthetic */ j lKK;

    d$2(d dVar, j jVar) {
        this.lKJ = dVar;
        this.lKK = jVar;
        super(0);
    }

    public final void onServiceConnected() {
        if (!u.aEM().lKw.a(this.lKK)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}

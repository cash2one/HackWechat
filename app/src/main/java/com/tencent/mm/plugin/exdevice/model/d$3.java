package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

class d$3 extends c$a {
    final /* synthetic */ long kxD;
    final /* synthetic */ d lKJ;
    final /* synthetic */ k lKL;

    d$3(d dVar, long j, k kVar) {
        this.lKJ = dVar;
        this.kxD = j;
        this.lKL = kVar;
        super(0);
    }

    public final void onServiceConnected() {
        if (!u.aEM().lKw.a(this.kxD, this.lKL)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
        }
    }
}

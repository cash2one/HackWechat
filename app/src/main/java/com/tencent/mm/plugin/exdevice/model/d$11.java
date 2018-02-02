package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;
import com.tencent.mm.sdk.platformtools.x;

class d$11 extends c$a {
    final /* synthetic */ d lKJ;

    d$11(d dVar, int i) {
        this.lKJ = dVar;
        super(0);
    }

    public final void onServiceConnected() {
        x.d("MicroMsg.exdevice.ExdeviceConnectManager", "onServiceConnected");
    }
}

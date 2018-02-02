package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;

class d$4 extends c$a {
    final /* synthetic */ d lKJ;
    final /* synthetic */ Runnable lKM;

    public d$4(d dVar, Runnable runnable) {
        this.lKJ = dVar;
        this.lKM = runnable;
        super(0);
    }

    public final void onServiceConnected() {
        this.lKM.run();
    }
}

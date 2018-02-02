package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;

class d$6 extends c$a {
    final /* synthetic */ boolean jbW;
    final /* synthetic */ d lKJ;
    final /* synthetic */ String lKQ;
    final /* synthetic */ long lKR;

    d$6(d dVar, int i, String str, long j, boolean z) {
        this.lKJ = dVar;
        this.lKQ = str;
        this.lKR = j;
        this.jbW = z;
        super(i);
    }

    public final void onServiceConnected() {
        d.a(this.lKJ).lQd = null;
        this.lKJ.b(this.lKQ, this.lKR, this.fsw, this.jbW);
    }
}

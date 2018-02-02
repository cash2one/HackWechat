package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.d.5;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;

class d$5$1 extends a {
    final /* synthetic */ 5 lKP;

    d$5$1(5 5) {
        this.lKP = 5;
        super(0);
    }

    public final void onServiceConnected() {
        this.lKP.lKJ.lKB.lQd = null;
        e.aEC().ai(this.lKP.lKN, this.lKP.lKO);
        synchronized (this.lKP.lKJ.lKI) {
            this.lKP.lKJ.lKI.notify();
        }
    }
}

package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.notification.d.d.2;

class d$2$1 implements Runnable {
    final /* synthetic */ ou oUv;
    final /* synthetic */ 2 oUw;

    d$2$1(2 2, ou ouVar) {
        this.oUw = 2;
        this.oUv = ouVar;
    }

    public final void run() {
        cf cfVar = this.oUv.fGM.fnB;
        if (d.GN(cfVar.field_talker)) {
            this.oUw.oUs.bC(cfVar);
        }
    }
}

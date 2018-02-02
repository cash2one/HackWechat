package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;

class m$4 implements Runnable {
    final /* synthetic */ z jXU;
    final /* synthetic */ p jeh;

    m$4(p pVar, z zVar) {
        this.jeh = pVar;
        this.jXU = zVar;
    }

    public final void run() {
        m.amH().put(this.jeh, this.jXU);
    }
}

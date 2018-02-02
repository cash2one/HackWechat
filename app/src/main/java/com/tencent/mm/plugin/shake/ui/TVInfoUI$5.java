package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.plugin.shake.e.c.a;

class TVInfoUI$5 implements Runnable {
    final /* synthetic */ a qsD;
    final /* synthetic */ TVInfoUI qsE;

    TVInfoUI$5(TVInfoUI tVInfoUI, a aVar) {
        this.qsE = tVInfoUI;
        this.qsD = aVar;
    }

    public final void run() {
        TVInfoUI.a(this.qsE, this.qsD);
        TVInfoUI.b(this.qsE, this.qsD);
    }
}

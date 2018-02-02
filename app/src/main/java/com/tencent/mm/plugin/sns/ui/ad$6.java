package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.u;

class ad$6 implements Runnable {
    final /* synthetic */ ad ruF;

    ad$6(ad adVar) {
        this.ruF = adVar;
    }

    public final void run() {
        u.makeText(this.ruF.fmM, j.eKc, 0).show();
    }
}

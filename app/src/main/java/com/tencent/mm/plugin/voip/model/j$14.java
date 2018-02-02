package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.R;

class j$14 implements Runnable {
    final /* synthetic */ j smu;

    j$14(j jVar) {
        this.smu = jVar;
    }

    public final void run() {
        d.bGj().stopRing();
        if (j.e(this.smu)) {
            d.bGj().dO(R.k.dAl, 0);
        } else {
            d.bGj().dO(R.k.dAl, 1);
        }
    }
}

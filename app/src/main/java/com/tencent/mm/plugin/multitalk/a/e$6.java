package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.R;

class e$6 implements Runnable {
    final /* synthetic */ e oGz;

    public e$6(e eVar) {
        this.oGz = eVar;
    }

    public final void run() {
        this.oGz.nDg.stop();
        this.oGz.nDg.e(R.k.dAl, false, 0);
    }
}

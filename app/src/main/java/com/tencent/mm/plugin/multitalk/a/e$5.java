package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.z.ar;

class e$5 implements Runnable {
    final /* synthetic */ e oGz;

    e$5(e eVar) {
        this.oGz = eVar;
    }

    public final void run() {
        this.oGz.nDg.stop();
        this.oGz.oGc = false;
        this.oGz.hXN.zd();
        ar.Hh().setSpeakerphoneOn(this.oGz.oGd);
    }
}

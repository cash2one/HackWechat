package com.tencent.mm.plugin.voip.model;

class d$1 implements Runnable {
    final /* synthetic */ d sjz;

    d$1(d dVar) {
        this.sjz = dVar;
    }

    public final void run() {
        this.sjz.sjx.dismiss();
        this.sjz.sjx = null;
    }
}

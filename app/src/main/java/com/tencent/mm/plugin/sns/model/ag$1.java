package com.tencent.mm.plugin.sns.model;

class ag$1 implements Runnable {
    final /* synthetic */ ag qWV;

    ag$1(ag agVar) {
        this.qWV = agVar;
    }

    public final void run() {
        if (this.qWV.qWU.size() > 50) {
            ag.a(this.qWV, 10);
        }
    }
}

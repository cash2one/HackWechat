package com.tencent.mm.pluginsdk.model;

class l$1 implements Runnable {
    final /* synthetic */ Object[] qTz;
    final /* synthetic */ l vdv;

    l$1(l lVar, Object[] objArr) {
        this.vdv = lVar;
        this.qTz = objArr;
    }

    public final void run() {
        this.vdv.handler.post(new 1(this, this.vdv.buP()));
    }
}

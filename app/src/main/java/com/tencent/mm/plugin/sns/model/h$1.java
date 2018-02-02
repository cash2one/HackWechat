package com.tencent.mm.plugin.sns.model;

class h$1 implements Runnable {
    final /* synthetic */ h qTA;
    final /* synthetic */ Object[] qTz;

    h$1(h hVar, Object[] objArr) {
        this.qTA = hVar;
        this.qTz = objArr;
    }

    public final void run() {
        this.qTA.handler.post(new 1(this, this.qTA.buP()));
    }
}

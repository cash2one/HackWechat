package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelsimple.m;

class h$1 implements Runnable {
    final /* synthetic */ int hwq;
    final /* synthetic */ h sgQ;

    h$1(h hVar, int i) {
        this.sgQ = hVar;
        this.hwq = i;
    }

    public final void run() {
        new m().a(this.sgQ.hmA, new 1(this));
    }
}

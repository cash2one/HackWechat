package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelsimple.m;

class e$1 implements Runnable {
    final /* synthetic */ int hwq;
    final /* synthetic */ e sgE;

    e$1(e eVar, int i) {
        this.sgE = eVar;
        this.hwq = i;
    }

    public final void run() {
        new m().a(this.sgE.hmA, new 1(this));
    }
}

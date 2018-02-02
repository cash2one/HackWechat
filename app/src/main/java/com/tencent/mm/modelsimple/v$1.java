package com.tencent.mm.modelsimple;

class v$1 implements Runnable {
    final /* synthetic */ v hNE;
    final /* synthetic */ int hwq;

    v$1(v vVar, int i) {
        this.hNE = vVar;
        this.hwq = i;
    }

    public final void run() {
        new m().a(this.hNE.hmA, new 1(this));
    }

    public final String toString() {
        return super.toString() + "|onGYNetEnd1";
    }
}

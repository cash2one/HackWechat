package com.tencent.mm.plugin.qqmail.b;

class v$1 implements Runnable {
    final /* synthetic */ int hBA = 100;
    final /* synthetic */ int jpF;
    final /* synthetic */ v ppT;

    v$1(v vVar, int i, int i2) {
        this.ppT = vVar;
        this.jpF = i;
    }

    public final void run() {
        this.ppT.ppG.O(this.ppT.poi, this.jpF, this.hBA);
    }
}

package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.modelsimple.m;

class p$1 implements Runnable {
    final /* synthetic */ int hwq;
    final /* synthetic */ p mfs;

    p$1(p pVar, int i) {
        this.mfs = pVar;
        this.hwq = i;
    }

    public final void run() {
        new m().a(p.a(this.mfs), new 1(this));
    }
}

package com.tencent.mm.ca;

class d$3 implements Runnable {
    final /* synthetic */ int kvg;
    final /* synthetic */ d xDk;

    d$3(d dVar, int i) {
        this.xDk = dVar;
        this.kvg = i;
    }

    public final void run() {
        d.a(this.xDk, this.kvg == 4 ? "/data/anr/" : d.xDf);
    }
}

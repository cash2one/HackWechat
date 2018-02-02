package com.tencent.mm.plugin.music.model.g;

class b$3 implements Runnable {
    final /* synthetic */ int ikE;
    final /* synthetic */ b oMj;

    b$3(b bVar, int i) {
        this.oMj = bVar;
        this.ikE = i;
    }

    public final void run() {
        if (this.oMj.bey()) {
            this.oMj.oMg.o(this.oMj.fAA);
        }
    }
}

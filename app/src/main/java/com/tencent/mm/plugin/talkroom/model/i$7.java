package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$7 implements Runnable {
    final /* synthetic */ int fmb;
    final /* synthetic */ i scj;

    i$7(i iVar, int i) {
        this.scj = iVar;
        this.fmb = i;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o rN : this.scj.gxL) {
                rN.rN(this.fmb);
            }
        }
    }
}

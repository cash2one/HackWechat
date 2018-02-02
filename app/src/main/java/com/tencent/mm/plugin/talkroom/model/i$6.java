package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$6 implements Runnable {
    final /* synthetic */ i scj;

    i$6(i iVar) {
        this.scj = iVar;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o aWc : this.scj.gxL) {
                aWc.aWc();
            }
        }
    }
}

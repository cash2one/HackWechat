package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$3 implements Runnable {
    final /* synthetic */ i scj;

    i$3(i iVar) {
        this.scj = iVar;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o aWf : this.scj.gxL) {
                aWf.aWf();
            }
        }
    }
}

package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$2 implements Runnable {
    final /* synthetic */ i scj;

    i$2(i iVar) {
        this.scj = iVar;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o aWe : this.scj.gxL) {
                aWe.aWe();
            }
        }
    }
}

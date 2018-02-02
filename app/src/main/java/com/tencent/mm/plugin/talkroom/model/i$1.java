package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$1 implements Runnable {
    final /* synthetic */ i scj;

    i$1(i iVar) {
        this.scj = iVar;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o aWb : this.scj.gxL) {
                aWb.aWb();
            }
        }
    }
}

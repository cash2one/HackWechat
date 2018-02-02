package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$12 implements Runnable {
    final /* synthetic */ i scj;

    i$12(i iVar) {
        this.scj = iVar;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o aWd : this.scj.gxL) {
                aWd.aWd();
            }
        }
    }
}

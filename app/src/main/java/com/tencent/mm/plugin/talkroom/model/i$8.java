package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$8 implements Runnable {
    final /* synthetic */ String fhl;
    final /* synthetic */ i scj;

    i$8(i iVar, String str) {
        this.scj = iVar;
        this.fhl = str;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o DM : this.scj.gxL) {
                DM.DM(this.fhl);
            }
        }
    }
}

package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$9 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ i scj;
    final /* synthetic */ String scn;

    i$9(i iVar, int i, int i2, String str) {
        this.scj = iVar;
        this.fma = i;
        this.fmb = i2;
        this.scn = str;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o j : this.scj.gxL) {
                j.j(this.fma, this.fmb, this.scn);
            }
        }
    }
}

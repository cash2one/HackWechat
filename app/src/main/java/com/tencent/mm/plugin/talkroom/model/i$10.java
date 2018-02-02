package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$10 implements Runnable {
    final /* synthetic */ String nSc;
    final /* synthetic */ String nSd;
    final /* synthetic */ i scj;

    i$10(i iVar, String str, String str2) {
        this.scj = iVar;
        this.nSc = str;
        this.nSd = str2;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o df : this.scj.gxL) {
                df.df(this.nSc, this.nSd);
            }
        }
    }
}

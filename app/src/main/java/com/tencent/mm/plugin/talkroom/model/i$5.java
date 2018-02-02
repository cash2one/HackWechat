package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.pluginsdk.q.o;

class i$5 implements Runnable {
    final /* synthetic */ i scj;
    final /* synthetic */ String sck;
    final /* synthetic */ int scl;
    final /* synthetic */ int scm;

    i$5(i iVar, String str, int i, int i2) {
        this.scj = iVar;
        this.sck = str;
        this.scl = i;
        this.scm = i2;
    }

    public final void run() {
        synchronized (this.scj.gxL) {
            for (o J : this.scj.gxL) {
                J.J(this.sck, this.scl, this.scm);
            }
        }
    }
}

package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$4 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ int fmb;
    final /* synthetic */ Object jby;

    g$4(g gVar, int i, Object obj) {
        this.AoK = gVar;
        this.fmb = i;
        this.jby = obj;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a g : this.AoK.gxL) {
                g.g(this.fmb, this.jby);
            }
        }
    }
}

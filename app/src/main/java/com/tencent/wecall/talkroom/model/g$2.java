package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$2 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ int fmb;

    g$2(g gVar, int i) {
        this.AoK = gVar;
        this.fmb = i;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a IZ : this.AoK.gxL) {
                IZ.IZ(this.fmb);
            }
        }
    }
}

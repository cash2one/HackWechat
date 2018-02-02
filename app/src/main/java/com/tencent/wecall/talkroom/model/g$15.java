package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$15 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ int AoN;

    g$15(g gVar, int i) {
        this.AoK = gVar;
        this.AoN = i;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a Ja : this.AoK.gxL) {
                Ja.Ja(this.AoN);
            }
        }
    }
}

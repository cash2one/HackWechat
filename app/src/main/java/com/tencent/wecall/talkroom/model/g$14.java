package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$14 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ boolean oTT;

    g$14(g gVar, boolean z) {
        this.AoK = gVar;
        this.oTT = z;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a gM : this.AoK.gxL) {
                gM.gM(this.oTT);
            }
        }
    }
}

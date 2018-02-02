package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$10 implements Runnable {
    final /* synthetic */ g AoK;

    g$10(g gVar) {
        this.AoK = gVar;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a cHN : this.AoK.gxL) {
                cHN.cHN();
            }
        }
    }
}

package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$18 implements Runnable {
    final /* synthetic */ g AoK;

    g$18(g gVar) {
        this.AoK = gVar;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a cHP : this.AoK.gxL) {
                cHP.cHP();
            }
        }
    }
}

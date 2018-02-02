package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$16 implements Runnable {
    final /* synthetic */ g AoK;

    g$16(g gVar) {
        this.AoK = gVar;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a bcC : this.AoK.gxL) {
                bcC.bcC();
            }
        }
    }
}

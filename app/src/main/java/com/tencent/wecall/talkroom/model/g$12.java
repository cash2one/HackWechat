package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$12 implements Runnable {
    final /* synthetic */ g AoK;

    g$12(g gVar) {
        this.AoK = gVar;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a cHO : this.AoK.gxL) {
                cHO.cHO();
            }
        }
    }
}

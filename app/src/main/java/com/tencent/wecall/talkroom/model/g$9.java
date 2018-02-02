package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$9 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ int iVx;

    g$9(g gVar, int i) {
        this.AoK = gVar;
        this.iVx = i;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a onStateChanged : this.AoK.gxL) {
                onStateChanged.onStateChanged(this.iVx);
            }
        }
    }
}

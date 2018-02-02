package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$1 implements Runnable {
    final /* synthetic */ int AoJ;
    final /* synthetic */ g AoK;

    g$1(g gVar, int i) {
        this.AoK = gVar;
        this.AoJ = i;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a tf : this.AoK.gxL) {
                tf.tf(this.AoJ);
            }
        }
    }
}

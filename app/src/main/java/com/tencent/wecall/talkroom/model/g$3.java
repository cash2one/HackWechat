package com.tencent.wecall.talkroom.model;

class g$3 implements Runnable {
    final /* synthetic */ g AoK;

    g$3(g gVar) {
        this.AoK = gVar;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (g$a aWb : this.AoK.gxL) {
                aWb.aWb();
            }
        }
    }
}

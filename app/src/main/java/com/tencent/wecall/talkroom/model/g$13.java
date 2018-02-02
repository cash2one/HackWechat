package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$13 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ String Aom;
    final /* synthetic */ int fmb;

    g$13(g gVar, String str, int i) {
        this.AoK = gVar;
        this.Aom = str;
        this.fmb = i;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a dK : this.AoK.gxL) {
                dK.dK(this.Aom, this.fmb);
            }
        }
    }
}

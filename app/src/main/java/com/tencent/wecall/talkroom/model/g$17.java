package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;

class g$17 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ byte[] AoO;
    final /* synthetic */ String Aom;

    g$17(g gVar, String str, byte[] bArr) {
        this.AoK = gVar;
        this.Aom = str;
        this.AoO = bArr;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a y : this.AoK.gxL) {
                y.y(this.Aom, this.AoO);
            }
        }
    }
}

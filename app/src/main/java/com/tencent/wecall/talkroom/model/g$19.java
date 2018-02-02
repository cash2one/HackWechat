package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;
import java.util.List;

class g$19 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ List AoP;

    g$19(g gVar, List list) {
        this.AoK = gVar;
        this.AoP = list;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a dK : this.AoK.gxL) {
                dK.dK(this.AoP);
            }
        }
    }
}

package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;
import java.util.List;

class g$11 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ List AoM;

    g$11(g gVar, List list) {
        this.AoK = gVar;
        this.AoM = list;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a bi : this.AoK.gxL) {
                bi.bi(this.AoM);
            }
        }
    }
}

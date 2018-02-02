package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.g.a;
import java.util.ArrayList;
import java.util.List;

class g$8 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ boolean AoL;
    final /* synthetic */ String Aom;

    g$8(g gVar, String str, boolean z) {
        this.AoK = gVar;
        this.Aom = str;
        this.AoL = z;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            List<a> arrayList = new ArrayList(this.AoK.gxL);
        }
        for (a bu : arrayList) {
            bu.bu(this.Aom, this.AoL);
        }
    }
}

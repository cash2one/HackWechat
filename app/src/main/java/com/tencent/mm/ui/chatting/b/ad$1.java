package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.modelvideo.t;

class ad$1 implements Runnable {
    final /* synthetic */ String qTs;
    final /* synthetic */ int yCD;
    final /* synthetic */ ad yCE;

    ad$1(ad adVar, String str, int i) {
        this.yCE = adVar;
        this.qTs = str;
        this.yCD = i;
    }

    public final void run() {
        t.Z(this.qTs, this.yCD);
    }
}

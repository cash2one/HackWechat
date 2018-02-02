package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;

class i$10 implements Runnable {
    final /* synthetic */ String qTs;
    final /* synthetic */ int yCD;
    final /* synthetic */ i yFV;

    i$10(i iVar, String str, int i) {
        this.yFV = iVar;
        this.qTs = str;
        this.yCD = i;
    }

    public final void run() {
        t.Z(this.qTs, this.yCD);
    }
}

package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.storage.au;

class w$6 implements Runnable {
    final /* synthetic */ au heZ;
    final /* synthetic */ w yBn;

    public w$6(w wVar, au auVar) {
        this.yBn = wVar;
        this.heZ = auVar;
    }

    public final void run() {
        d.pPH.a(403, 6, 1, false);
        this.yBn.aQ(this.heZ);
    }
}

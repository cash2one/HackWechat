package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.storage.au;

class w$7 implements Runnable {
    final /* synthetic */ au heZ;
    final /* synthetic */ w yBn;

    public w$7(w wVar, au auVar) {
        this.yBn = wVar;
        this.heZ = auVar;
    }

    public final void run() {
        d.pPH.a(403, 7, 1, false);
        this.yBn.aQ(this.heZ);
    }
}

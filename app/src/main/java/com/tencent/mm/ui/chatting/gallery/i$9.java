package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.s.e;
import com.tencent.mm.sdk.platformtools.bh;

class i$9 implements Runnable {
    final /* synthetic */ i yFV;

    i$9(i iVar) {
        this.yFV = iVar;
    }

    public final void run() {
        String aZD = e.aZD();
        if (bh.ov(aZD)) {
            g.pQN.k(14092, "0");
        } else {
            g.pQN.k(14092, aZD);
        }
    }
}

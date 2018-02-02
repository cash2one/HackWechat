package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.g.a.gm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;

class FTSMainUI$7 implements Runnable {
    final /* synthetic */ FTSMainUI qdk;

    FTSMainUI$7(FTSMainUI fTSMainUI) {
        this.qdk = fTSMainUI;
    }

    public final void run() {
        b gmVar = new gm();
        gmVar.fwC.context = ac.getContext();
        gmVar.fwC.actionCode = 3;
        a.xef.m(gmVar);
    }
}

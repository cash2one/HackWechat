package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.g.a.st;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class MallIndexUI$11 implements Runnable {
    final /* synthetic */ st lni;
    final /* synthetic */ MallIndexUI omF;

    MallIndexUI$11(MallIndexUI mallIndexUI, st stVar) {
        this.omF = mallIndexUI;
        this.lni = stVar;
    }

    public final void run() {
        if (!bh.ov(this.lni.fKB.fKD)) {
            e.a(this.omF.olW, this.lni.fKB.fKD, this.lni.fKB.content, this.lni.fKB.url);
        }
    }
}

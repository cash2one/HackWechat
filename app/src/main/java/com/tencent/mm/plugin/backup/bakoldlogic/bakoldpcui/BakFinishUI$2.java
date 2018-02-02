package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakFinishUI$2 implements Runnable {
    final /* synthetic */ BakFinishUI krN;

    BakFinishUI$2(BakFinishUI bakFinishUI) {
        this.krN = bakFinishUI;
    }

    public final void run() {
        a.aql().aqm().krc = -1;
        BakFinishUI.b(this.krN);
    }
}

package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.sdk.platformtools.x;

class BakOperatingUI$3 implements Runnable {
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$3(BakOperatingUI bakOperatingUI) {
        this.krW = bakOperatingUI;
    }

    public final void run() {
        x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
        BakOperatingUI.o(this.krW);
    }
}

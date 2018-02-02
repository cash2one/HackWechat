package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

class BakOperatingUI$2 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$2(BakOperatingUI bakOperatingUI, int i) {
        this.krW = bakOperatingUI;
        this.fma = i;
    }

    public final void run() {
        x.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", new Object[]{Integer.valueOf(this.fma)});
        if (this.fma == 15) {
            BakOperatingUI.n(this.krW);
            return;
        }
        MMWizardActivity.A(this.krW, new Intent(this.krW, BakConnErrorUI.class));
    }
}

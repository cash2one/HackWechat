package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

class BakFinishUI$3 implements Runnable {
    final /* synthetic */ BakFinishUI krN;

    BakFinishUI$3(BakFinishUI bakFinishUI) {
        this.krN = bakFinishUI;
    }

    public final void run() {
        x.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
        MMWizardActivity.A(this.krN, new Intent(this.krN, BakConnErrorUI.class));
    }
}

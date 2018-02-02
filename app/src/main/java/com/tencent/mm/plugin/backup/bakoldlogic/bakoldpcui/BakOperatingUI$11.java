package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

class BakOperatingUI$11 implements Runnable {
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$11(BakOperatingUI bakOperatingUI) {
        this.krW = bakOperatingUI;
    }

    public final void run() {
        Intent intent = new Intent(this.krW, BakFinishUI.class);
        intent.putExtra("cmd", BakOperatingUI.j(this.krW));
        MMWizardActivity.A(this.krW, intent);
    }
}

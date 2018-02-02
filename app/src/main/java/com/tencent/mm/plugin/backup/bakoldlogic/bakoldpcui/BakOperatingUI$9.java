package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.R;

class BakOperatingUI$9 implements Runnable {
    final /* synthetic */ int ikE;
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$9(BakOperatingUI bakOperatingUI, int i) {
        this.krW = bakOperatingUI;
        this.ikE = i;
    }

    public final void run() {
        if (BakOperatingUI.h(this.krW) != null) {
            BakOperatingUI.h(this.krW).setProgress(this.ikE);
        }
        if (BakOperatingUI.i(this.krW) != null && BakOperatingUI.k(this.krW) != null) {
            BakOperatingUI.i(this.krW).setText(this.krW.getString(R.l.dJZ) + this.ikE + "%");
            BakOperatingUI.k(this.krW).setText(this.krW.getString(R.l.dKh));
        }
    }
}

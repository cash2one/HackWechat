package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;

class CleanNewUI$7 implements Runnable {
    final /* synthetic */ int hBA;
    final /* synthetic */ int irm;
    final /* synthetic */ CleanNewUI lhD;

    CleanNewUI$7(CleanNewUI cleanNewUI, int i, int i2) {
        this.lhD = cleanNewUI;
        this.irm = i;
        this.hBA = i2;
    }

    public final void run() {
        CleanNewUI.k(this.lhD).setText(this.lhD.getString(R.l.dDH, new Object[]{((this.irm * 100) / this.hBA) + "%"}));
    }
}

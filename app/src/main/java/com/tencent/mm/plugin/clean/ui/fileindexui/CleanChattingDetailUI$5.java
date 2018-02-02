package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;

class CleanChattingDetailUI$5 implements Runnable {
    final /* synthetic */ int hBA;
    final /* synthetic */ int htd;
    final /* synthetic */ CleanChattingDetailUI lgF;

    CleanChattingDetailUI$5(CleanChattingDetailUI cleanChattingDetailUI, int i, int i2) {
        this.lgF = cleanChattingDetailUI;
        this.htd = i;
        this.hBA = i2;
    }

    public final void run() {
        CleanChattingDetailUI.c(this.lgF).setMessage(this.lgF.getString(R.l.dTM, new Object[]{((this.htd * 100) / this.hBA) + "%"}));
    }
}

package com.tencent.mm.plugin.clean.ui.newui;

import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.7;

class CleanMsgUI$7$1 implements Runnable {
    final /* synthetic */ long lgH;
    final /* synthetic */ 7 lhW;

    CleanMsgUI$7$1(7 7, long j) {
        this.lhW = 7;
        this.lgH = j;
    }

    public final void run() {
        if (CleanMsgUI.c(this.lhW.lhT) != null) {
            CleanMsgUI.c(this.lhW.lhT).dismiss();
        }
        d.bU(d.ayo() + this.lgH);
        d.bT(d.ayn() - this.lgH);
        CleanMsgUI cleanMsgUI = this.lhW.lhT;
        d.ayo();
        CleanMsgUI.a(cleanMsgUI, d.ayl(), d.ayn(), d.aym());
    }
}

package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ComposeUI.c;

class ComposeUI$c$1 implements Runnable {
    final /* synthetic */ c prF;

    ComposeUI$c$1(c cVar) {
        this.prF = cVar;
    }

    public final void run() {
        if (!this.prF.prr.pqB.psV.isFocused() && !this.prF.prr.pqE.psV.isFocused() && this.prF.prr.pqB.psU.size() == 0 && this.prF.prr.pqE.psU.size() == 0 && this.prF.prr.pqB.bkV() && this.prF.prr.pqE.bkV()) {
            this.prF.prr.pqz.setVisibility(0);
            this.prF.prr.pqA.setVisibility(8);
            this.prF.prr.pqD.setVisibility(8);
        }
    }
}

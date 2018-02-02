package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.ui.chatting.e.e.7;

class e$7$1 implements Runnable {
    final /* synthetic */ int yHE;
    final /* synthetic */ 7 yHF;

    e$7$1(7 7, int i) {
        this.yHF = 7;
        this.yHE = i;
    }

    public final void run() {
        this.yHF.yHA.yHv.yyh = false;
        if (this.yHF.yHA.yHu != null) {
            this.yHF.yHA.yHu.z(this.yHF.yHb, this.yHE);
        }
    }
}

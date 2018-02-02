package com.tencent.mm.ui.account;

import com.tencent.mm.ui.account.RegSetInfoUI.32;

class RegSetInfoUI$32$1 implements Runnable {
    final /* synthetic */ 32 xSr;

    RegSetInfoUI$32$1(32 32) {
        this.xSr = 32;
    }

    public final void run() {
        RegSetInfoUI.a(this.xSr.xSg).clearFocus();
        RegSetInfoUI.a(this.xSr.xSg).requestFocus();
    }
}

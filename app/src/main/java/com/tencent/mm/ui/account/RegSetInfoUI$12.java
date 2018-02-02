package com.tencent.mm.ui.account;

class RegSetInfoUI$12 implements Runnable {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$12(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final void run() {
        RegSetInfoUI.i(this.xSg).requestFocus();
        RegSetInfoUI.b(this.xSg).clearFocus();
    }
}

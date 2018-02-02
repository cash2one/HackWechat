package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.a;

class IPCallContactUI$8 implements Runnable {
    final /* synthetic */ IPCallContactUI nIW;

    IPCallContactUI$8(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final void run() {
        a.aTi().a(IPCallContactUI.g(this.nIW), false);
    }
}

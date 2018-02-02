package com.tencent.mm.plugin.ipcall.ui;

class IPCallContactUI$10 implements Runnable {
    final /* synthetic */ IPCallContactUI nIW;

    IPCallContactUI$10(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final void run() {
        if (IPCallContactUI.d(this.nIW) != null && IPCallContactUI.b(this.nIW) != null && !IPCallContactUI.d(this.nIW).kFT) {
            IPCallContactUI.d(this.nIW).CN(IPCallContactUI.h(this.nIW));
            IPCallContactUI.f(this.nIW).sendEmptyMessage(2);
            IPCallContactUI.b(this.nIW).invalidateViews();
        }
    }
}

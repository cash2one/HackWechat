package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.g.a.jt;

class WalletSelectAddrUI$9 implements Runnable {
    final /* synthetic */ WalletSelectAddrUI iom;
    final /* synthetic */ jt iop;

    WalletSelectAddrUI$9(WalletSelectAddrUI walletSelectAddrUI, jt jtVar) {
        this.iom = walletSelectAddrUI;
        this.iop = jtVar;
    }

    public final void run() {
        WalletSelectAddrUI.j(this.iom).post(new 1(this));
    }
}

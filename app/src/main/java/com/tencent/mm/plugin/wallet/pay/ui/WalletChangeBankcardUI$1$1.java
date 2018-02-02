package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.tf;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.1;

class WalletChangeBankcardUI$1$1 implements Runnable {
    final /* synthetic */ tf sEV;
    final /* synthetic */ 1 sEW;

    WalletChangeBankcardUI$1$1(1 1, tf tfVar) {
        this.sEW = 1;
        this.sEV = tfVar;
    }

    public final void run() {
        if (-1 == this.sEV.fLI.result) {
            this.sEW.sEU.ze(-1);
        }
    }
}

package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.g.a.st;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$8 implements Runnable {
    final /* synthetic */ st lni;
    final /* synthetic */ WalletBalanceManagerUI szV;

    WalletBalanceManagerUI$8(WalletBalanceManagerUI walletBalanceManagerUI, st stVar) {
        this.szV = walletBalanceManagerUI;
        this.lni = stVar;
    }

    public final void run() {
        if (!bh.ov(this.lni.fKB.fKD)) {
            e.a(this.szV.szq, this.lni.fKB.fKD, this.lni.fKB.content, this.lni.fKB.url);
        }
    }
}

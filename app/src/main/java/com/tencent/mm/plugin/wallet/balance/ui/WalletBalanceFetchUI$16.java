package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.g.a.st;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceFetchUI$16 implements Runnable {
    final /* synthetic */ st lni;
    final /* synthetic */ WalletBalanceFetchUI szH;

    WalletBalanceFetchUI$16(WalletBalanceFetchUI walletBalanceFetchUI, st stVar) {
        this.szH = walletBalanceFetchUI;
        this.lni = stVar;
    }

    public final void run() {
        if (bh.ov(this.lni.fKB.fKD)) {
            x.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
        } else {
            e.a(WalletBalanceFetchUI.j(this.szH), this.lni.fKB.fKD, this.lni.fKB.content, this.lni.fKB.url);
        }
    }
}

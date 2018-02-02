package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletBalanceFetchPwdInputUI$4 implements a {
    final /* synthetic */ WalletBalanceFetchPwdInputUI szi;

    WalletBalanceFetchPwdInputUI$4(WalletBalanceFetchPwdInputUI walletBalanceFetchPwdInputUI) {
        this.szi = walletBalanceFetchPwdInputUI;
    }

    public final void bho() {
        x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: pwd cancel.finish");
        WalletBalanceFetchPwdInputUI.a(this.szi).dismiss();
        this.szi.finish();
    }
}

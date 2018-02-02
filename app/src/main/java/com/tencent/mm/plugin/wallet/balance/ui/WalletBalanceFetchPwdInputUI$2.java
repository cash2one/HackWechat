package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.m.c;

class WalletBalanceFetchPwdInputUI$2 implements c {
    final /* synthetic */ WalletBalanceFetchPwdInputUI szi;

    WalletBalanceFetchPwdInputUI$2(WalletBalanceFetchPwdInputUI walletBalanceFetchPwdInputUI) {
        this.szi = walletBalanceFetchPwdInputUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        WalletBalanceFetchPwdInputUI.a(this.szi).dismiss();
        if (this.szi.cCc() != null) {
            this.szi.cCd().k(new Object[]{str});
        }
    }
}

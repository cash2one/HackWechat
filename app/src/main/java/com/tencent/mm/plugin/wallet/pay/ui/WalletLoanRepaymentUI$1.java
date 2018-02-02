package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.m.c;

class WalletLoanRepaymentUI$1 implements c {
    final /* synthetic */ WalletLoanRepaymentUI sFh;

    WalletLoanRepaymentUI$1(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.sFh = walletLoanRepaymentUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        WalletLoanRepaymentUI.a(this.sFh, str);
        this.sFh.l(new s(WalletLoanRepaymentUI.a(this.sFh), WalletLoanRepaymentUI.b(this.sFh), (byte) 0));
    }
}

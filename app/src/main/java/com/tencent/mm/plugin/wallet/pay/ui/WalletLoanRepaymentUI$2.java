package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletLoanRepaymentUI$2 implements OnClickListener {
    final /* synthetic */ WalletLoanRepaymentUI sFh;

    WalletLoanRepaymentUI$2(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.sFh = walletLoanRepaymentUI;
    }

    public final void onClick(View view) {
        WalletLoanRepaymentUI.c(this.sFh);
        if (this.sFh.szh != null) {
            this.sFh.szh.dismiss();
        }
    }
}

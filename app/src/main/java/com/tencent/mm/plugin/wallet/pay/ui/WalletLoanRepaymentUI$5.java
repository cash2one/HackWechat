package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletLoanRepaymentUI$5 implements OnClickListener {
    final /* synthetic */ WalletLoanRepaymentUI sFh;

    WalletLoanRepaymentUI$5(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.sFh = walletLoanRepaymentUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.sFh.aYf()) {
            this.sFh.finish();
        }
    }
}

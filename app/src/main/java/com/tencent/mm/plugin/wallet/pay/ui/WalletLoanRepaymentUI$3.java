package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletLoanRepaymentUI$3 implements OnCancelListener {
    final /* synthetic */ WalletLoanRepaymentUI sFh;

    WalletLoanRepaymentUI$3(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.sFh = walletLoanRepaymentUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.sFh.szh != null) {
            this.sFh.szh.cancel();
            this.sFh.setResult(0);
            this.sFh.finish();
        }
    }
}

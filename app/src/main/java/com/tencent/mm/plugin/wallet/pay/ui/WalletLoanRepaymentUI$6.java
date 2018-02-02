package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c.a;

class WalletLoanRepaymentUI$6 implements a {
    final /* synthetic */ WalletLoanRepaymentUI sFh;

    WalletLoanRepaymentUI$6(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        this.sFh = walletLoanRepaymentUI;
    }

    public final Intent l(int i, Bundle bundle) {
        if (i == -1) {
            WalletLoanRepaymentUI.b(this.sFh, WalletLoanRepaymentUI.b(this.sFh));
        } else {
            ad bLr = o.bLr();
            if (bLr.bLB()) {
                WalletLoanRepaymentUI.a(this.sFh, bLr.bLC(), WalletLoanRepaymentUI.d(this.sFh), WalletLoanRepaymentUI.e(this.sFh));
            } else {
                this.sFh.setResult(0, null);
            }
        }
        return null;
    }
}

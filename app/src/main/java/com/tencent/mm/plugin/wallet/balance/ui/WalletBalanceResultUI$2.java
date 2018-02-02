package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBalanceResultUI$2 implements OnClickListener {
    final /* synthetic */ WalletBalanceResultUI sAh;

    WalletBalanceResultUI$2(WalletBalanceResultUI walletBalanceResultUI) {
        this.sAh = walletBalanceResultUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WalletBalanceResultUI.b(this.sAh);
    }
}

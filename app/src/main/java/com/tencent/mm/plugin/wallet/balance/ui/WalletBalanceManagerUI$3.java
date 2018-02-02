package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBalanceManagerUI$3 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI szV;

    WalletBalanceManagerUI$3(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.szV = walletBalanceManagerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        WalletBalanceManagerUI.c(this.szV);
    }
}

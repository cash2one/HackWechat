package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBalanceFetchUI$5 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI szH;

    WalletBalanceFetchUI$5(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.szH = walletBalanceFetchUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        WalletBalanceFetchUI.k(this.szH);
    }
}

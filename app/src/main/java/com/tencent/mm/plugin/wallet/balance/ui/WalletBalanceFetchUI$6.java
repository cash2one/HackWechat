package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.b;

class WalletBalanceFetchUI$6 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI szH;

    WalletBalanceFetchUI$6(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.szH = walletBalanceFetchUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        String str = "";
        if (WalletBalanceFetchUI.c(this.szH) != null) {
            str = WalletBalanceFetchUI.c(this.szH).field_bankcardType;
        }
        WalletBalanceFetchUI.l(this.szH);
        WalletBalanceFetchUI.m(this.szH);
        this.szH.l(new b(WalletBalanceFetchUI.n(this.szH), "CNY", str, WalletBalanceFetchUI.o(this.szH)));
    }
}

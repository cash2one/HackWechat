package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.b;

class WalletBalanceFetchUI$2 implements OnClickListener {
    final /* synthetic */ WalletBalanceFetchUI szH;
    final /* synthetic */ b szI;

    WalletBalanceFetchUI$2(WalletBalanceFetchUI walletBalanceFetchUI, b bVar) {
        this.szH = walletBalanceFetchUI;
        this.szI = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (!WalletBalanceFetchUI.a(this.szH, this.szI)) {
            WalletBalanceFetchUI.a(this.szH, this.szI.fwY);
            WalletBalanceFetchUI.b(this.szH, this.szI);
        }
    }
}

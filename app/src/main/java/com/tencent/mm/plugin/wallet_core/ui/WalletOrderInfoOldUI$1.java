package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOrderInfoOldUI$1 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    WalletOrderInfoOldUI$1(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sUK.done();
    }
}

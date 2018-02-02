package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOrderInfoUI$2 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoUI sVh;

    WalletOrderInfoUI$2(WalletOrderInfoUI walletOrderInfoUI) {
        this.sVh = walletOrderInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sVh.finish();
    }
}

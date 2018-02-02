package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOrderInfoNewUI$15 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$15(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sUp.done();
    }
}

package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletPayUI$13 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;
    final /* synthetic */ int sGi;

    WalletPayUI$13(WalletPayUI walletPayUI, int i) {
        this.sGh = walletPayUI;
        this.sGi = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sGh.Q(this.sGi, false);
    }
}

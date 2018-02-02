package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletPayUI$15 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$15(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sGh.sFF.putInt("key_pay_flag", 3);
        this.sGh.I(this.sGh.sFF);
    }
}

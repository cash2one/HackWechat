package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletPayUPayUI$4 implements OnClickListener {
    final /* synthetic */ WalletPayUPayUI tcY;

    WalletPayUPayUI$4(WalletPayUPayUI walletPayUPayUI) {
        this.tcY = walletPayUPayUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WalletPayUPayUI.h(this.tcY).putInt("key_pay_flag", 3);
        this.tcY.I(WalletPayUPayUI.i(this.tcY));
    }
}

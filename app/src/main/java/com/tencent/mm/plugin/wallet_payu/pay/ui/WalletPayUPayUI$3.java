package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletPayUPayUI$3 implements OnCancelListener {
    final /* synthetic */ WalletPayUPayUI tcY;

    WalletPayUPayUI$3(WalletPayUPayUI walletPayUPayUI) {
        this.tcY = walletPayUPayUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WalletPayUPayUI.f(this.tcY);
        WalletPayUPayUI.g(this.tcY);
        if (this.tcY.aYf()) {
            this.tcY.finish();
        }
    }
}

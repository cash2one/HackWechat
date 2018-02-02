package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletIapUI$1 implements OnCancelListener {
    final /* synthetic */ WalletIapUI tbh;

    WalletIapUI$1(WalletIapUI walletIapUI) {
        this.tbh = walletIapUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tbh.setResult(0);
        this.tbh.finish();
    }
}

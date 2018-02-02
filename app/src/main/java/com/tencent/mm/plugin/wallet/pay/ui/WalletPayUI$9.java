package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletPayUI$9 implements OnCancelListener {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$9(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.sGh.mzL = null;
        this.sGh.szh = null;
        if (this.sGh.aYf()) {
            this.sGh.finish();
        }
        this.sGh.sES = null;
    }
}

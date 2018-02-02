package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletChangeBankcardUI$7 implements OnCancelListener {
    final /* synthetic */ WalletChangeBankcardUI sEU;

    WalletChangeBankcardUI$7(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.sEU = walletChangeBankcardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.sEU.mzL = null;
        if (WalletChangeBankcardUI.b(this.sEU).getVisibility() != 0) {
            this.sEU.bKb();
        }
        this.sEU.sES = null;
    }
}

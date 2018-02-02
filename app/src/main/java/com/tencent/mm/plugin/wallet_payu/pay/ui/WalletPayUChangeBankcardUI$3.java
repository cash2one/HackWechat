package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletPayUChangeBankcardUI$3 implements OnCancelListener {
    final /* synthetic */ WalletPayUChangeBankcardUI tcW;

    WalletPayUChangeBankcardUI$3(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        this.tcW = walletPayUChangeBankcardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WalletPayUChangeBankcardUI.j(this.tcW);
        if (WalletPayUChangeBankcardUI.k(this.tcW).getVisibility() != 0) {
            WalletPayUChangeBankcardUI.l(this.tcW);
        }
    }
}

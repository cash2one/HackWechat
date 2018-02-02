package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBankcardDetailUI$9 implements OnClickListener {
    final /* synthetic */ int kmP;
    final /* synthetic */ WalletBankcardDetailUI sCq;

    WalletBankcardDetailUI$9(WalletBankcardDetailUI walletBankcardDetailUI, int i) {
        this.sCq = walletBankcardDetailUI;
        this.kmP = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.kmP == 2) {
            WalletBankcardDetailUI.b(this.sCq);
        }
        dialogInterface.dismiss();
    }
}

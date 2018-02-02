package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBindUI$5 implements OnClickListener {
    final /* synthetic */ WalletBindUI sCR;

    WalletBindUI$5(WalletBindUI walletBindUI) {
        this.sCR = walletBindUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sCR.finish();
    }
}

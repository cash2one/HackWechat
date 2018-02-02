package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBindUI$7 implements OnClickListener {
    final /* synthetic */ WalletBindUI sCR;

    WalletBindUI$7(WalletBindUI walletBindUI) {
        this.sCR = walletBindUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sCR.finish();
    }
}

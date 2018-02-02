package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletBindUI$6 implements OnClickListener {
    final /* synthetic */ WalletBindUI sCR;

    WalletBindUI$6(WalletBindUI walletBindUI) {
        this.sCR = walletBindUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sCR.finish();
    }
}

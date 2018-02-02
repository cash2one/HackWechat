package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;

class WalletBaseUI$1 implements OnClickListener {
    final /* synthetic */ WalletBaseUI zJd;

    WalletBaseUI$1(WalletBaseUI walletBaseUI) {
        this.zJd = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.c(this.zJd, null, -10000);
    }
}

package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletBindCardResultUI$2 implements OnClickListener {
    final /* synthetic */ WalletBindCardResultUI sRR;

    WalletBindCardResultUI$2(WalletBindCardResultUI walletBindCardResultUI) {
        this.sRR = walletBindCardResultUI;
    }

    public final void onClick(View view) {
        this.sRR.done();
    }
}

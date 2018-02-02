package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletBankcardIdUI$5 implements OnClickListener {
    final /* synthetic */ WalletBankcardIdUI sRo;

    WalletBankcardIdUI$5(WalletBankcardIdUI walletBankcardIdUI) {
        this.sRo = walletBankcardIdUI;
    }

    public final void onClick(View view) {
        this.sRo.showDialog(1);
    }
}

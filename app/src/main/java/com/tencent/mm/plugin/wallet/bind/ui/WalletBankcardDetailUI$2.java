package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletBankcardDetailUI$2 implements OnClickListener {
    final /* synthetic */ WalletBankcardDetailUI sCq;

    WalletBankcardDetailUI$2(WalletBankcardDetailUI walletBankcardDetailUI) {
        this.sCq = walletBankcardDetailUI;
    }

    public final void onClick(View view) {
        this.sCq.showDialog(0);
    }
}

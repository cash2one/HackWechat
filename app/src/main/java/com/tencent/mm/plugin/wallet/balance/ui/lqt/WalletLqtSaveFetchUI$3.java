package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class WalletLqtSaveFetchUI$3 implements OnCheckedChangeListener {
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$3(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        this.sBv = walletLqtSaveFetchUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            WalletLqtSaveFetchUI.a(this.sBv, true);
        } else {
            WalletLqtSaveFetchUI.a(this.sBv, false);
        }
    }
}

package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class WalletCardElementUI$10 implements OnCheckedChangeListener {
    final /* synthetic */ WalletCardElementUI sSA;

    WalletCardElementUI$10(WalletCardElementUI walletCardElementUI) {
        this.sSA = walletCardElementUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        WalletCardElementUI.b(this.sSA);
    }
}

package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

class WalletCardElementUI$1 implements a {
    final /* synthetic */ WalletCardElementUI sSA;

    WalletCardElementUI$1(WalletCardElementUI walletCardElementUI) {
        this.sSA = walletCardElementUI;
    }

    public final void hx(boolean z) {
        if (!z) {
            WalletCardElementUI.a(this.sSA);
            this.sSA.vf.putParcelable("key_history_bankcard", null);
        }
        WalletCardElementUI.b(this.sSA);
    }
}

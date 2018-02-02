package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.text.Editable;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.a;

class WalletPayUCardElementUI$2 extends a {
    final /* synthetic */ WalletPayUCardElementUI tbR;

    WalletPayUCardElementUI$2(WalletPayUCardElementUI walletPayUCardElementUI) {
        this.tbR = walletPayUCardElementUI;
        super(walletPayUCardElementUI, (byte) 0);
    }

    public final void afterTextChanged(Editable editable) {
        WalletPayUCardElementUI.a(this.tbR, WalletPayUCardElementUI.b(this.tbR), editable);
    }
}

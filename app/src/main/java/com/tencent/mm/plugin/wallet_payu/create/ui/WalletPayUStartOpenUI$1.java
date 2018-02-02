package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.text.Editable;
import android.text.TextWatcher;

class WalletPayUStartOpenUI$1 implements TextWatcher {
    final /* synthetic */ WalletPayUStartOpenUI tcq;

    WalletPayUStartOpenUI$1(WalletPayUStartOpenUI walletPayUStartOpenUI) {
        this.tcq = walletPayUStartOpenUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        WalletPayUStartOpenUI.a(this.tcq);
    }
}

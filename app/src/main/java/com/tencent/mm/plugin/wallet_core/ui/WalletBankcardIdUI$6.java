package com.tencent.mm.plugin.wallet_core.ui;

import android.text.Editable;
import android.text.TextWatcher;

class WalletBankcardIdUI$6 implements TextWatcher {
    final /* synthetic */ WalletBankcardIdUI sRo;

    WalletBankcardIdUI$6(WalletBankcardIdUI walletBankcardIdUI) {
        this.sRo = walletBankcardIdUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.sRo.sRi.XO() && !WalletBankcardIdUI.b(this.sRo)) {
            WalletBankcardIdUI.c(this.sRo);
            this.sRo.sRi.bmK();
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}

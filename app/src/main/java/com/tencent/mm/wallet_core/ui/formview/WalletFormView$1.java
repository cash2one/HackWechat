package com.tencent.mm.wallet_core.ui.formview;

import android.text.Editable;
import android.text.TextWatcher;

class WalletFormView$1 implements TextWatcher {
    private boolean pEM = false;
    final /* synthetic */ WalletFormView zJP;

    WalletFormView$1(WalletFormView walletFormView) {
        this.zJP = walletFormView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean XO = this.zJP.XO();
        if (!(WalletFormView.i(this.zJP) == null || XO == this.pEM)) {
            WalletFormView.i(this.zJP).hx(XO);
            this.pEM = this.zJP.XO();
        }
        WalletFormView.j(this.zJP);
    }
}

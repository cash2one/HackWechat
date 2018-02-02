package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;

class BankRemitBankcardInputUI$22 implements TextWatcher {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$22(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        BankRemitBankcardInputUI.d(this.pIo);
        BankRemitBankcardInputUI.e(this.pIo);
        if (!BankRemitBankcardInputUI.f(this.pIo) || BankRemitBankcardInputUI.g(this.pIo) == null) {
            BankRemitBankcardInputUI.a(this.pIo, true);
        } else {
            BankRemitBankcardInputUI.i(this.pIo).getFilter().filter(editable.toString(), BankRemitBankcardInputUI.h(this.pIo));
        }
        if (BankRemitBankcardInputUI.j(this.pIo)) {
            BankRemitBankcardInputUI.k(this.pIo);
        }
        BankRemitBankcardInputUI.l(this.pIo);
        BankRemitBankcardInputUI.m(this.pIo);
    }
}

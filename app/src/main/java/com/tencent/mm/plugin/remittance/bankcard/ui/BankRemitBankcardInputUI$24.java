package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ag;

class BankRemitBankcardInputUI$24 implements TextWatcher {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$24(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        BankRemitBankcardInputUI.o(this.pIo);
        ag.h(new Runnable(this) {
            final /* synthetic */ BankRemitBankcardInputUI$24 pIx;

            {
                this.pIx = r1;
            }

            public final void run() {
                BankRemitBankcardInputUI.l(this.pIx.pIo);
            }
        }, 200);
    }
}

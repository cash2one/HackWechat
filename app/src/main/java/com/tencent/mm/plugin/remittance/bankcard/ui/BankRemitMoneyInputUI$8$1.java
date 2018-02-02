package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.8;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h.b;

class BankRemitMoneyInputUI$8$1 implements b {
    final /* synthetic */ 8 pJz;

    BankRemitMoneyInputUI$8$1(8 8) {
        this.pJz = 8;
    }

    public final boolean v(CharSequence charSequence) {
        if (bh.ov(charSequence.toString())) {
            BankRemitMoneyInputUI.c(this.pJz.pJw, null);
            BankRemitMoneyInputUI.i(this.pJz.pJw);
        } else {
            BankRemitMoneyInputUI.c(this.pJz.pJw, charSequence.toString());
            BankRemitMoneyInputUI.i(this.pJz.pJw);
        }
        return true;
    }
}

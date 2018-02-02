package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g$a;

class BankRemitSelectPayeeUI$9 implements g$a {
    final /* synthetic */ BankRemitSelectPayeeUI pJR;

    BankRemitSelectPayeeUI$9(BankRemitSelectPayeeUI bankRemitSelectPayeeUI) {
        this.pJR = bankRemitSelectPayeeUI;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[]{kVar});
    }
}

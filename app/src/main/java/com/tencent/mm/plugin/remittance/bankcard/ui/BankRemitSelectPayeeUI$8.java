package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitSelectPayeeUI$8 implements a {
    final /* synthetic */ BankRemitSelectPayeeUI pJR;
    final /* synthetic */ j pJV;

    BankRemitSelectPayeeUI$8(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, j jVar) {
        this.pJR = bankRemitSelectPayeeUI;
        this.pJV = jVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
        BankRemitSelectPayeeUI.b(this.pJR, this.pJV.pHd, this.pJV.iIj);
    }
}

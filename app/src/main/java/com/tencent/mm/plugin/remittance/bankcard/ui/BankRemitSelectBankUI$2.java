package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitSelectBankUI$2 implements a {
    final /* synthetic */ BankRemitSelectBankUI pJH;
    final /* synthetic */ h pJI;

    BankRemitSelectBankUI$2(BankRemitSelectBankUI bankRemitSelectBankUI, h hVar) {
        this.pJH = bankRemitSelectBankUI;
        this.pJI = hVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", new Object[]{this.pJI});
    }
}

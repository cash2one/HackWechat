package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitBankcardInputUI$5 implements a {
    final /* synthetic */ BankRemitBankcardInputUI pIo;
    final /* synthetic */ g pIq;

    BankRemitBankcardInputUI$5(BankRemitBankcardInputUI bankRemitBankcardInputUI, g gVar) {
        this.pIo = bankRemitBankcardInputUI;
        this.pIq = gVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.pIq.pHi.liH), this.pIq.pHi.liI});
        BankRemitBankcardInputUI.r(this.pIo);
    }
}

package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitBankcardInputUI$6 implements a {
    final /* synthetic */ BankRemitBankcardInputUI pIo;
    final /* synthetic */ g pIq;

    BankRemitBankcardInputUI$6(BankRemitBankcardInputUI bankRemitBankcardInputUI, g gVar) {
        this.pIo = bankRemitBankcardInputUI;
        this.pIq = gVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        if (this.pIq.pHi.vIJ == null) {
            x.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
            BankRemitBankcardInputUI.r(this.pIo);
            return;
        }
        BankRemitBankcardInputUI.a(this.pIo, new BankcardElemParcel(this.pIq.pHi.vIJ));
        BankRemitBankcardInputUI.y(this.pIo);
        BankRemitBankcardInputUI.z(this.pIo);
        BankRemitBankcardInputUI.A(this.pIo);
        BankRemitBankcardInputUI.B(this.pIo);
        BankRemitBankcardInputUI.l(this.pIo);
    }
}

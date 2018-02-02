package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitDetailUI$5 implements a {
    final /* synthetic */ BankRemitDetailUI pIP;
    final /* synthetic */ l pIQ;

    BankRemitDetailUI$5(BankRemitDetailUI bankRemitDetailUI, l lVar) {
        this.pIP = bankRemitDetailUI;
        this.pIQ = lVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[]{Integer.valueOf(this.pIQ.pHn.state), Integer.valueOf(this.pIQ.pHn.nZd), Integer.valueOf(this.pIQ.pHn.wGW), this.pIQ.pHn.wGX});
        BankRemitDetailUI.a(this.pIP, this.pIQ.pHn.state);
        BankRemitDetailUI.a(this.pIP, this.pIQ.pHn.state, this.pIQ.pHn.wGV);
        BankRemitDetailUI.a(this.pIP, this.pIQ.pHn);
        BankRemitDetailUI.a(this.pIP).setVisibility(0);
    }
}

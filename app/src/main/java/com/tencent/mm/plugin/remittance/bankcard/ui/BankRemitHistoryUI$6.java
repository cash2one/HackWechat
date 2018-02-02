package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitHistoryUI$6 implements a {
    final /* synthetic */ BankRemitHistoryUI pIU;

    BankRemitHistoryUI$6(BankRemitHistoryUI bankRemitHistoryUI) {
        this.pIU = bankRemitHistoryUI;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[]{kVar});
    }
}

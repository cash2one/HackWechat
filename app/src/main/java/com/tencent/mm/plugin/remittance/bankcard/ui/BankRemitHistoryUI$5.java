package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitHistoryUI$5 implements a {
    final /* synthetic */ BankRemitHistoryUI pIU;
    final /* synthetic */ i pIV;

    BankRemitHistoryUI$5(BankRemitHistoryUI bankRemitHistoryUI, i iVar) {
        this.pIU = bankRemitHistoryUI;
        this.pIV = iVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        if (this.pIV.pHk.wqs != null) {
            x.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[]{Integer.valueOf(this.pIV.pHk.wqs.size())});
            if (this.pIV.pHk.wqs.size() < this.pIV.asN) {
                x.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[]{Integer.valueOf(BankRemitHistoryUI.f(this.pIU))});
                BankRemitHistoryUI.g(this.pIU);
                BankRemitHistoryUI.b(this.pIU).removeFooterView(BankRemitHistoryUI.h(this.pIU));
            }
            if (this.pIV.pHk.wqs != null) {
                BankRemitHistoryUI.a(this.pIU, BankRemitHistoryUI.f(this.pIU) + this.pIV.pHk.wqs.size());
                BankRemitHistoryUI.i(this.pIU).addAll(this.pIV.pHk.wqs);
                BankRemitHistoryUI.j(this.pIU).notifyDataSetChanged();
                return;
            }
            return;
        }
        x.i("MicroMsg.BankRemitHistoryUI", "return history is null");
        BankRemitHistoryUI.g(this.pIU);
        BankRemitHistoryUI.b(this.pIU).removeFooterView(BankRemitHistoryUI.h(this.pIU));
    }
}

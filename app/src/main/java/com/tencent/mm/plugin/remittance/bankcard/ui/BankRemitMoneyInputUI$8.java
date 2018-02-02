package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.plugin.wxpay.a.i;

class BankRemitMoneyInputUI$8 implements a {
    final /* synthetic */ BankRemitMoneyInputUI pJw;

    BankRemitMoneyInputUI$8(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        this.pJw = bankRemitMoneyInputUI;
    }

    public final void aze() {
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(this.pJw, this.pJw.getString(i.uHP), BankRemitMoneyInputUI.h(this.pJw), this.pJw.getString(i.uNg), 20, new 1(this), new 2(this));
        g.pQN.h(14673, new Object[]{Integer.valueOf(4)});
    }
}

package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.remittance.bankcard.model.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

class BankRemitMoneyInputUI$3 extends r {
    final /* synthetic */ BankRemitMoneyInputUI pJw;

    BankRemitMoneyInputUI$3(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        this.pJw = bankRemitMoneyInputUI;
    }

    public final void ayX() {
        x.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double dO = a.dO(BankRemitMoneyInputUI.c(this.pJw).getText(), "100");
        if (dO <= 0.0d) {
            x.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[]{Double.valueOf(dO)});
            Toast.makeText(this.pJw, i.uHM, 1).show();
        } else if (dO > ((double) BankRemitMoneyInputUI.d(this.pJw))) {
            x.w("MicroMsg.BankRemitMoneyInputUI", "more than max: %s", new Object[]{Double.valueOf(dO)});
            Toast.makeText(this.pJw, this.pJw.getString(i.uHN, new Object[]{a.dN(BankRemitMoneyInputUI.d(this.pJw), "100")}), 0).show();
        } else {
            BankRemitMoneyInputUI.e(this.pJw);
        }
    }
}

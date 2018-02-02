package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitDetailUI$3 implements a {
    final /* synthetic */ BankRemitDetailUI pIP;

    BankRemitDetailUI$3(BankRemitDetailUI bankRemitDetailUI) {
        this.pIP = bankRemitDetailUI;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[]{kVar});
        Toast.makeText(this.pIP, a$i.uHw, 1).show();
    }
}

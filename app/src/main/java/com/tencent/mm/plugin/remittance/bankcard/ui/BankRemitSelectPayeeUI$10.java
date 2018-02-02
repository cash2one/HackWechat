package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitSelectPayeeUI$10 implements a {
    final /* synthetic */ BankRemitSelectPayeeUI pJR;
    final /* synthetic */ f pJS;

    BankRemitSelectPayeeUI$10(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, f fVar) {
        this.pJR = bankRemitSelectPayeeUI;
        this.pJS = fVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.pJS.pHh.liH), this.pJS.pHh.liI});
        if (!bh.ov(this.pJS.pHh.liI)) {
            Toast.makeText(this.pJR, this.pJS.pHh.liI, 1).show();
        }
    }
}

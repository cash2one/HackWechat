package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g$a;

class BankRemitSelectPayeeUI$7 implements g$a {
    final /* synthetic */ BankRemitSelectPayeeUI pJR;
    final /* synthetic */ j pJV;

    BankRemitSelectPayeeUI$7(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, j jVar) {
        this.pJR = bankRemitSelectPayeeUI;
        this.pJV = jVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.pJV.pHl.liH), this.pJV.pHl.liI});
        if (!bh.ov(this.pJV.pHl.liI)) {
            Toast.makeText(this.pJR, this.pJV.pHl.liI, 1).show();
        }
    }
}

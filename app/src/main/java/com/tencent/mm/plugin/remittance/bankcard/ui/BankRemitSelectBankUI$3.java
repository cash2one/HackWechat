package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g$a;

class BankRemitSelectBankUI$3 implements g$a {
    final /* synthetic */ BankRemitSelectBankUI pJH;
    final /* synthetic */ h pJI;

    BankRemitSelectBankUI$3(BankRemitSelectBankUI bankRemitSelectBankUI, h hVar) {
        this.pJH = bankRemitSelectBankUI;
        this.pJI = hVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", new Object[]{Integer.valueOf(this.pJI.pHj.liH), this.pJI.pHj.liI});
        if (!bh.ov(this.pJI.pHj.liI)) {
            Toast.makeText(this.pJH, this.pJI.pHj.liI, 1).show();
        }
    }
}

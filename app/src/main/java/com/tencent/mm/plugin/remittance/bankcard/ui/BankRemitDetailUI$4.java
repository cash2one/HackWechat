package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitDetailUI$4 implements a {
    final /* synthetic */ BankRemitDetailUI pIP;
    final /* synthetic */ l pIQ;

    BankRemitDetailUI$4(BankRemitDetailUI bankRemitDetailUI, l lVar) {
        this.pIP = bankRemitDetailUI;
        this.pIQ = lVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[]{Integer.valueOf(this.pIQ.pHn.liH), this.pIQ.pHn.liI});
        if (bh.ov(this.pIQ.pHn.liI)) {
            Toast.makeText(this.pIP, i.uHw, 1).show();
        } else {
            Toast.makeText(this.pIP, this.pIQ.pHn.liI, 1).show();
        }
    }
}

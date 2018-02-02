package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitBankcardInputUI$11 implements a {
    final /* synthetic */ BankRemitBankcardInputUI pIo;
    final /* synthetic */ d pIs;

    BankRemitBankcardInputUI$11(BankRemitBankcardInputUI bankRemitBankcardInputUI, d dVar) {
        this.pIo = bankRemitBankcardInputUI;
        this.pIs = dVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[]{Integer.valueOf(this.pIs.pHf.liH), this.pIs.pHf.liI});
        if (!bh.ov(this.pIs.pHf.liI)) {
            Toast.makeText(this.pIo, this.pIs.pHf.liI, 1).show();
        }
    }
}

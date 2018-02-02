package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class BankRemitBankcardInputUI$15 implements a {
    final /* synthetic */ BankRemitBankcardInputUI pIo;
    final /* synthetic */ k pIu;

    BankRemitBankcardInputUI$15(BankRemitBankcardInputUI bankRemitBankcardInputUI, k kVar) {
        this.pIo = bankRemitBankcardInputUI;
        this.pIu = kVar;
    }

    public final void f(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[]{Integer.valueOf(this.pIu.pHm.liH), this.pIu.pHm.liI});
        if (!bh.ov(this.pIu.pHm.liI)) {
            Toast.makeText(this.pIo, this.pIu.pHm.liI, 1).show();
        }
        this.pIo.finish();
    }
}

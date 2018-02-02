package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g$a;

class BankRemitBankcardInputUI$2 implements g$a {
    final /* synthetic */ BankRemitBankcardInputUI pIo;
    final /* synthetic */ a pIp;

    BankRemitBankcardInputUI$2(BankRemitBankcardInputUI bankRemitBankcardInputUI, a aVar) {
        this.pIo = bankRemitBankcardInputUI;
        this.pIp = aVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[]{Integer.valueOf(this.pIp.pHc.liH), this.pIp.pHc.liI});
        if (!bh.ov(this.pIp.pHc.liI)) {
            Toast.makeText(this.pIo, this.pIp.pHc.liI, 1).show();
        }
    }
}

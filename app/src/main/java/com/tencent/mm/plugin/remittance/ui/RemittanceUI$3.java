package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;

class RemittanceUI$3 implements a {
    final /* synthetic */ e pPC;
    final /* synthetic */ RemittanceUI pPD;

    RemittanceUI$3(RemittanceUI remittanceUI, e eVar) {
        this.pPD = remittanceUI;
        this.pPC = eVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.RemittanceUI", "mask_name: %s", new Object[]{this.pPC.pKl.vUA});
        this.pPD.pMj = this.pPC.pKl.vUA;
        this.pPD.bnO();
    }
}

package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$16 implements b$a {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$16(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final void a(n nVar) {
        if (!bh.ov(nVar.url)) {
            PhoneRechargeUI.d(this.pDm, PhoneRechargeUI.c(this.pDm, nVar.url));
        } else if (PhoneRechargeUI.a(this.pDm, nVar)) {
            PhoneRechargeUI.b(this.pDm, nVar.id);
        } else {
            x.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
        }
    }
}

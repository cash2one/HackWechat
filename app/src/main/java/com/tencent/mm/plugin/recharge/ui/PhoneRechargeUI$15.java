package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$15 implements b$a {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$15(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final void a(n nVar) {
        if (nVar == null) {
            x.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
        } else if (PhoneRechargeUI.a(this.pDm, nVar)) {
            PhoneRechargeUI.b(this.pDm, nVar.id);
        }
    }
}

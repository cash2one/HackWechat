package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.g.a.sz;
import com.tencent.mm.plugin.recharge.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$13 extends c<sz> {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$13(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
        this.xen = sz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sz szVar = (sz) bVar;
        if (szVar instanceof sz) {
            if (szVar.fLs.result != -1) {
                x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
            } else if (!PhoneRechargeUI.o(this.pDm)) {
                x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                a.bmr().a(new com.tencent.mm.plugin.recharge.model.a(PhoneRechargeUI.a(this.pDm).getText(), PhoneRechargeUI.b(this.pDm).pCu != null ? bh.ou(PhoneRechargeUI.b(this.pDm).pCu.name) : "", 0));
                this.pDm.finish();
                PhoneRechargeUI.p(this.pDm);
            }
            return true;
        }
        x.f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
        return false;
    }
}

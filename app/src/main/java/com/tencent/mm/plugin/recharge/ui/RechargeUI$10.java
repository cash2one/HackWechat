package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.g.a.sz;
import com.tencent.mm.plugin.recharge.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class RechargeUI$10 extends c<sz> {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$10(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
        this.xen = sz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sz szVar = (sz) bVar;
        if (szVar instanceof sz) {
            if (szVar.fLs.result != -1) {
                x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
            } else if (!RechargeUI.p(this.pDQ)) {
                x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                a.bmr().a(RechargeUI.e(this.pDQ).bmw());
                this.pDQ.finish();
                RechargeUI.q(this.pDQ);
            }
            return true;
        }
        x.f("MicroMsg.MallRechargeUI", "mismatched event");
        return false;
    }
}

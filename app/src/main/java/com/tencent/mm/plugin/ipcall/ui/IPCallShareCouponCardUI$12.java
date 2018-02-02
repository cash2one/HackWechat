package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.Iterator;

class IPCallShareCouponCardUI$12 implements c {
    final /* synthetic */ IPCallShareCouponCardUI nMs;

    IPCallShareCouponCardUI$12(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.nMs = iPCallShareCouponCardUI;
    }

    public final void a(n nVar) {
        Iterator it = IPCallShareCouponCardUI.a(this.nMs, IPCallShareCouponCardUI.b(this.nMs).wXJ).iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            CharSequence F = IPCallShareCouponCardUI.F(this.nMs.mController.xIM, num.intValue());
            int rE = IPCallShareCouponCardUI.rE(num.intValue());
            if (!(F == null || rE == -1)) {
                nVar.a(num.intValue(), F, rE);
            }
        }
    }
}

package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$10 implements a<Void, v> {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$10(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        v vVar = (v) obj;
        if (vVar == null) {
            x.e("MicroMsg.PaylistAAUI", "queryDetailRes is null!!!");
            PaylistAAUI.a(this.ikp, null);
        } else {
            x.i("MicroMsg.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", new Object[]{vVar, vVar.vCW, Integer.valueOf(vVar.type), Integer.valueOf(vVar.state), Integer.valueOf(vVar.vDB), Integer.valueOf(vVar.vDh), Integer.valueOf(vVar.vDC), Integer.valueOf(vVar.vDb.size())});
            x.i("MicroMsg.PaylistAAUI", "paid_num: %s, plan_num: %s, activity_amount: %s", new Object[]{Integer.valueOf(vVar.vDz), Integer.valueOf(vVar.vDx), Long.valueOf(vVar.vDJ)});
            PaylistAAUI.c(this.ikp).setVisibility(0);
            PaylistAAUI.b(this.ikp, vVar.vDv);
            PaylistAAUI.a(this.ikp, vVar.vDb.size() + 1);
            PaylistAAUI.c(this.ikp, vVar.title);
            PaylistAAUI.a(this.ikp, vVar);
            PaylistAAUI.b(this.ikp, vVar);
            PaylistAAUI.c(this.ikp, vVar);
            PaylistAAUI.d(this.ikp, vVar);
            PaylistAAUI.e(this.ikp, vVar);
            if (PaylistAAUI.d(this.ikp) != null) {
                PaylistAAUI.d(this.ikp).dismiss();
                PaylistAAUI.e(this.ikp);
            }
        }
        return zBS;
    }
}

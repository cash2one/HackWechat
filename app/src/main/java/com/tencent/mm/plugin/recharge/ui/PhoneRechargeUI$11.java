package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h$a;
import java.util.List;

class PhoneRechargeUI$11 implements h$a {
    final /* synthetic */ PhoneRechargeUI pDm;
    final /* synthetic */ List pDn;
    final /* synthetic */ String pDo;

    PhoneRechargeUI$11(PhoneRechargeUI phoneRechargeUI, List list, String str) {
        this.pDm = phoneRechargeUI;
        this.pDn = list;
        this.pDo = str;
    }

    public final void vm(int i) {
        x.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[]{Integer.valueOf(i)});
        PhoneRechargeUI.b(this.pDm).b(new a((String) this.pDn.get(i), this.pDo, 1));
        PhoneRechargeUI.n(this.pDm);
    }
}

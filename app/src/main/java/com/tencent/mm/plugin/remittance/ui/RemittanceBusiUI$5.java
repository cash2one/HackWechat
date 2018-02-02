package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.model.d;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.u;

class RemittanceBusiUI$5 implements d {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$5(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void a(int i, int i2, g gVar) {
        if (i != 0 || i2 != 0) {
            u.makeText(this.pOd.mController.xIM, this.pOd.getString(i.uRf), 0).show();
        } else if (gVar.pKo.kLO != 0) {
            u.makeText(this.pOd.mController.xIM, gVar.pKo.kLP, 0).show();
        }
    }
}

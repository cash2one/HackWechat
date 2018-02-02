package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.r;

class RemittanceBaseUI$12 extends r {
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$12(RemittanceBaseUI remittanceBaseUI) {
        this.pMw = remittanceBaseUI;
    }

    public final void ayX() {
        if (this.pMw.pLT == 33) {
            this.pMw.dQ(this.pMw.gAT, this.pMw.pMg);
        } else {
            this.pMw.pLR = bh.getDouble(this.pMw.llY.getText(), 0.0d);
            if (!this.pMw.llY.XO()) {
                u.makeText(this.pMw.mController.xIM, i.uPA, 0).show();
            } else if (this.pMw.pLR < 0.01d) {
                this.pMw.bnK();
            } else {
                this.pMw.dQ(this.pMw.gAT, null);
            }
        }
        if (RemittanceBaseUI.a(this.pMw) == 0.0d) {
            if (this.pMw.irz == 1) {
                g.pQN.h(12689, new Object[]{Integer.valueOf(15), Integer.valueOf(1)});
            } else {
                g.pQN.h(12689, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
            }
        }
        if (this.pMw.irz == 1 && !bh.ov(this.pMw.gAT)) {
            g.pQN.h(14074, new Object[]{Integer.valueOf(2)});
        }
    }
}

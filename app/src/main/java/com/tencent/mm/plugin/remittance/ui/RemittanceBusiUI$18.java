package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.r;

class RemittanceBusiUI$18 extends r {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$18(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void ayX() {
        g.pQN.h(15235, new Object[]{Integer.valueOf(5)});
        if (!RemittanceBusiUI.j(this.pOd)) {
            RemittanceBusiUI.a(this.pOd, RemittanceBusiUI.n(this.pOd));
        }
        if (RemittanceBusiUI.o(this.pOd) <= 0.0d) {
            u.makeText(this.pOd.mController.xIM, i.uPA, 0).show();
            return;
        }
        String str;
        String str2 = "MicroMsg.RemittanceBusiUI";
        String str3 = "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s";
        Object[] objArr = new Object[3];
        objArr[0] = this.pOd.pNZ;
        if (this.pOd.pNZ == null) {
            str = "";
        } else {
            str = this.pOd.pNZ.pKr;
        }
        objArr[1] = str;
        objArr[2] = Boolean.valueOf(this.pOd.pNW);
        x.i(str2, str3, objArr);
        if (RemittanceBusiUI.g(this.pOd) == 32) {
            if (!this.pOd.pNW) {
                RemittanceBusiUI.p(this.pOd);
                return;
            } else if (this.pOd.pNZ == null || this.pOd.pNZ.pKu != ((int) (RemittanceBusiUI.o(this.pOd) * 100.0d))) {
                RemittanceBusiUI.a(this.pOd, new 2(this), 0);
                return;
            } else if (this.pOd.pNZ == null || !this.pOd.pNZ.pKr) {
                if (this.pOd.pNZ != null) {
                    this.pOd.pNZ.pKp = new 1(this);
                    return;
                }
                return;
            }
        }
        RemittanceBusiUI.p(this.pOd);
    }
}

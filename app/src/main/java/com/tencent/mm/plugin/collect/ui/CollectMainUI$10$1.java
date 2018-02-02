package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.10;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class CollectMainUI$10$1 implements c {
    final /* synthetic */ 10 lnm;

    CollectMainUI$10$1(10 10) {
        this.lnm = 10;
    }

    public final void a(n nVar) {
        a.ayE();
        if (a.ayG()) {
            nVar.add(0, 1, 0, i.uIA);
        } else {
            nVar.add(0, 1, 0, i.uIH);
        }
        if (this.lnm.lnl != null) {
            for (int i = 0; i < this.lnm.lnl.size(); i++) {
                aqz com_tencent_mm_protocal_c_aqz = (aqz) this.lnm.lnl.get(i);
                if (!bh.ov(com_tencent_mm_protocal_c_aqz.fyY)) {
                    nVar.add(0, (i + 1) + 1, 0, com_tencent_mm_protocal_c_aqz.fyY);
                }
            }
        }
    }
}

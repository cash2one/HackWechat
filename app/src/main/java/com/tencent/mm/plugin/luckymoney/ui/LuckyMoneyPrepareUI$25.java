package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;

class LuckyMoneyPrepareUI$25 extends r {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$25(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final void ayX() {
        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.ojC)), Integer.valueOf(4)});
        if (LuckyMoneyPrepareUI.b(this.ojC).aXG() != 0) {
            u.makeText(this.ojC.mController.xIM, a$i.uPA, 0).show();
            return;
        }
        long v;
        int aXO = LuckyMoneyPrepareUI.a(this.ojC).aXO();
        double aXH = LuckyMoneyPrepareUI.b(this.ojC).aXH();
        long j = 0;
        if (LuckyMoneyPrepareUI.c(this.ojC) == 1) {
            v = e.v(aXH);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().set(356354, Integer.valueOf(aXO));
        } else {
            v = e.v(((double) aXO) * aXH);
            j = e.v(aXH);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().set(356353, Integer.valueOf(aXO));
        }
        String input = LuckyMoneyPrepareUI.g(this.ojC).getInput();
        if (bh.ov(input)) {
            input = bh.ov(LuckyMoneyPrepareUI.h(this.ojC)) ? this.ojC.getString(a$i.uJN) : LuckyMoneyPrepareUI.h(this.ojC);
        }
        if (LuckyMoneyPrepareUI.i(this.ojC) == 2) {
            this.ojC.b(new c(aXO, (int) v, LuckyMoneyPrepareUI.c(this.ojC), (int) j), false);
        } else {
            String stringExtra = this.ojC.getIntent().getStringExtra("key_username");
            if (LuckyMoneyPrepareUI.j(this.ojC) == 1) {
                k adVar;
                x.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB");
                if (!LuckyMoneyPrepareUI.k(this.ojC) || bh.ov(stringExtra)) {
                    adVar = new ad(aXO, v, j, LuckyMoneyPrepareUI.c(this.ojC), input, n.aXg(), null, null, q.FS(), q.FU(), LuckyMoneyPrepareUI.l(this.ojC));
                } else {
                    adVar = new ad(aXO, v, j, LuckyMoneyPrepareUI.c(this.ojC), input, n.aXg(), stringExtra, n.gt(stringExtra), q.FS(), q.FU(), LuckyMoneyPrepareUI.l(this.ojC));
                }
                this.ojC.b(adVar, false);
            } else {
                k xVar;
                x.i("MicroMsg.LuckyMoneyPrepareUI", "currency=" + LuckyMoneyPrepareUI.j(this.ojC));
                this.ojC.ji(1645);
                if (!LuckyMoneyPrepareUI.k(this.ojC) || bh.ov(stringExtra)) {
                    xVar = new com.tencent.mm.plugin.luckymoney.b.x(aXO, v, j, LuckyMoneyPrepareUI.c(this.ojC), input, null, n.aXg(), q.FS(), LuckyMoneyPrepareUI.j(this.ojC));
                } else {
                    xVar = new com.tencent.mm.plugin.luckymoney.b.x(aXO, v, j, LuckyMoneyPrepareUI.c(this.ojC), input, stringExtra, n.aXg(), q.FS(), LuckyMoneyPrepareUI.j(this.ojC));
                }
                this.ojC.b(xVar, false);
            }
        }
        if (LuckyMoneyPrepareUI.m(this.ojC) != null) {
            LuckyMoneyPrepareUI.m(this.ojC).show();
        } else {
            LuckyMoneyPrepareUI.a(this.ojC, com.tencent.mm.wallet_core.ui.g.a(this.ojC.mController.xIM, true, new 1(this)));
        }
    }
}

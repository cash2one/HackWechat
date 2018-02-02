package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyPrepareUI$26 implements a {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$26(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final boolean uF() {
        double d;
        if (LuckyMoneyPrepareUI.b(this.ojC).aXG() == 3 || LuckyMoneyPrepareUI.a(this.ojC).aXG() == 3) {
            d = 0.0d;
        } else {
            int aXO = LuckyMoneyPrepareUI.a(this.ojC).aXO();
            d = LuckyMoneyPrepareUI.b(this.ojC).aXH();
            if (LuckyMoneyPrepareUI.c(this.ojC) == 0) {
                d *= (double) aXO;
            }
        }
        if (d == 0.0d || d > LuckyMoneyPrepareUI.d(this.ojC).obA || LuckyMoneyPrepareUI.p(this.ojC).aXF()) {
            LuckyMoneyPrepareUI.q(this.ojC).setClickable(false);
            LuckyMoneyPrepareUI.q(this.ojC).setEnabled(false);
        } else {
            LuckyMoneyPrepareUI.q(this.ojC).setClickable(true);
            LuckyMoneyPrepareUI.q(this.ojC).setEnabled(true);
        }
        x.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + LuckyMoneyPrepareUI.p(this.ojC).aXF());
        LuckyMoneyPrepareUI.r(this.ojC).cfK();
        return false;
    }
}

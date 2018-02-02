package com.tencent.mm.plugin.luckymoney.sns;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsLuckyMoneyPrepareUI$17 implements a {
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

    SnsLuckyMoneyPrepareUI$17(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.ofF = snsLuckyMoneyPrepareUI;
    }

    public final boolean uF() {
        double d;
        if (this.ofF.ofq.aXG() == 3 || this.ofF.ofp.aXG() == 3) {
            d = 0.0d;
        } else {
            int aXO = this.ofF.ofp.aXO();
            d = this.ofF.ofq.aXH();
            if (SnsLuckyMoneyPrepareUI.a(this.ofF) == 0) {
                d *= (double) aXO;
            }
        }
        if (d == 0.0d || d > SnsLuckyMoneyPrepareUI.b(this.ofF).obA || SnsLuckyMoneyPrepareUI.i(this.ofF).aXF()) {
            this.ofF.nZJ.setClickable(false);
            this.ofF.nZJ.setEnabled(false);
        } else {
            this.ofF.nZJ.setClickable(true);
            this.ofF.nZJ.setEnabled(true);
        }
        x.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(this.ofF).aXF());
        SnsLuckyMoneyPrepareUI.j(this.ofF).cfK();
        return false;
    }
}

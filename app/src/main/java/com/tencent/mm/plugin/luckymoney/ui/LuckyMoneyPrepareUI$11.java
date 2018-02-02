package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.g$a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$11 implements g$a {
    final /* synthetic */ SpannableString ofJ;
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$11(LuckyMoneyPrepareUI luckyMoneyPrepareUI, SpannableString spannableString) {
        this.ojC = luckyMoneyPrepareUI;
        this.ofJ = spannableString;
    }

    public final void onClick(View view) {
        int aXO = LuckyMoneyPrepareUI.a(this.ojC).aXO();
        double aXH = LuckyMoneyPrepareUI.b(this.ojC).aXH();
        LuckyMoneyPrepareUI.a(this.ojC, 0);
        LuckyMoneyPrepareUI.b(this.ojC).mType = LuckyMoneyPrepareUI.c(this.ojC);
        LuckyMoneyPrepareUI.b(this.ojC).gu(false);
        LuckyMoneyPrepareUI.b(this.ojC).setTitle(this.ojC.getString(i.uKZ));
        if (aXH > 0.0d && aXO > 0) {
            LuckyMoneyPrepareUI.b(this.ojC).DZ(e.t(aXH / ((double) aXO)));
        }
        LuckyMoneyPrepareUI.b(this.ojC).oia = LuckyMoneyPrepareUI.d(this.ojC).obD;
        LuckyMoneyPrepareUI.e(this.ojC).setText(this.ofJ);
        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.ojC)), Integer.valueOf(3)});
    }
}

package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyWishFooter$2 implements OnClickListener {
    final /* synthetic */ LuckyMoneyWishFooter okD;

    LuckyMoneyWishFooter$2(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.okD = luckyMoneyWishFooter;
    }

    public final void onClick(View view) {
        this.okD.oky = true;
        x.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.b(this.okD));
        if (LuckyMoneyWishFooter.b(this.okD) == 0) {
            LuckyMoneyWishFooter.c(this.okD).aWs();
            LuckyMoneyWishFooter.a(this.okD).requestFocus();
            LuckyMoneyWishFooter.d(this.okD);
            LuckyMoneyWishFooter.e(this.okD).setImageResource(h.dBc);
            LuckyMoneyWishFooter.a(this.okD, 1);
            LuckyMoneyWishFooter.f(this.okD);
            return;
        }
        LuckyMoneyWishFooter.f(this.okD);
        LuckyMoneyWishFooter.a(this.okD).requestFocus();
        LuckyMoneyWishFooter.g(this.okD).setVisibility(8);
        LuckyMoneyWishFooter.c(this.okD).showVKB();
        LuckyMoneyWishFooter.e(this.okD).setImageResource(h.dBb);
        LuckyMoneyWishFooter.a(this.okD, 0);
    }
}

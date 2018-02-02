package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.a;

class LuckyMoneyWishFooter$5 implements OnClickListener {
    final /* synthetic */ LuckyMoneyWishFooter okD;
    final /* synthetic */ a okE;

    LuckyMoneyWishFooter$5(LuckyMoneyWishFooter luckyMoneyWishFooter, a aVar) {
        this.okD = luckyMoneyWishFooter;
        this.okE = aVar;
    }

    public final void onClick(View view) {
        this.okE.DY(LuckyMoneyWishFooter.a(this.okD).getText().toString());
        LuckyMoneyWishFooter.a(this.okD).setText("");
    }
}

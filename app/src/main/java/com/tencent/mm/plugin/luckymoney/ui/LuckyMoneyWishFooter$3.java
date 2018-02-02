package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.wxpay.a$e;

class LuckyMoneyWishFooter$3 implements OnTouchListener {
    final /* synthetic */ LuckyMoneyWishFooter okD;

    LuckyMoneyWishFooter$3(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        this.okD = luckyMoneyWishFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        LuckyMoneyWishFooter.f(this.okD);
        LuckyMoneyWishFooter.g(this.okD).setVisibility(8);
        LuckyMoneyWishFooter.g(this.okD).onPause();
        LuckyMoneyWishFooter.e(this.okD).setImageResource(a$e.bBn);
        LuckyMoneyWishFooter.a(this.okD, 0);
        return false;
    }
}

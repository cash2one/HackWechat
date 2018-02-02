package com.tencent.mm.plugin.luckymoney.ui;

class LuckyMoneyAutoScrollView$2 implements Runnable {
    final /* synthetic */ LuckyMoneyAutoScrollView ogo;

    LuckyMoneyAutoScrollView$2(LuckyMoneyAutoScrollView luckyMoneyAutoScrollView) {
        this.ogo = luckyMoneyAutoScrollView;
    }

    public final void run() {
        LuckyMoneyAutoScrollView.a(this.ogo).setVisibility(8);
        LuckyMoneyAutoScrollView.b(this.ogo).setVisibility(8);
        LuckyMoneyAutoScrollView.c(this.ogo).setVisibility(8);
        LuckyMoneyAutoScrollView.d(this.ogo).setVisibility(0);
        LuckyMoneyAutoScrollView.e(this.ogo).setVisibility(0);
        LuckyMoneyAutoScrollView.f(this.ogo).setVisibility(0);
        if (LuckyMoneyAutoScrollView.g(this.ogo) != null) {
            LuckyMoneyAutoScrollView.g(this.ogo).aXx();
        }
    }
}

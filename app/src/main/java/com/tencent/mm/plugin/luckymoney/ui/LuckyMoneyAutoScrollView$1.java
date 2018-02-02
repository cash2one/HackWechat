package com.tencent.mm.plugin.luckymoney.ui;

class LuckyMoneyAutoScrollView$1 implements Runnable {
    final /* synthetic */ LuckyMoneyAutoScrollView ogo;

    LuckyMoneyAutoScrollView$1(LuckyMoneyAutoScrollView luckyMoneyAutoScrollView) {
        this.ogo = luckyMoneyAutoScrollView;
    }

    public final void run() {
        LuckyMoneyAutoScrollView.a(this.ogo).aXv();
        LuckyMoneyAutoScrollView.b(this.ogo).aXv();
        LuckyMoneyAutoScrollView.c(this.ogo).aXv();
    }
}

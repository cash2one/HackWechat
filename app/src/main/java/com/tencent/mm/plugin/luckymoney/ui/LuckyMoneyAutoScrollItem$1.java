package com.tencent.mm.plugin.luckymoney.ui;

class LuckyMoneyAutoScrollItem$1 implements Runnable {
    final /* synthetic */ long ofV;
    final /* synthetic */ LuckyMoneyAutoScrollItem ofW;

    LuckyMoneyAutoScrollItem$1(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem, long j) {
        this.ofW = luckyMoneyAutoScrollItem;
        this.ofV = j;
    }

    public final void run() {
        LuckyMoneyAutoScrollItem.a(this.ofW, new 1(this, this.ofV).start());
    }
}

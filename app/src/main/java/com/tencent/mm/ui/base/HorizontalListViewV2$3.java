package com.tencent.mm.ui.base;

class HorizontalListViewV2$3 implements Runnable {
    final /* synthetic */ HorizontalListViewV2 xYC;

    HorizontalListViewV2$3(HorizontalListViewV2 horizontalListViewV2) {
        this.xYC = horizontalListViewV2;
    }

    public final void run() {
        this.xYC.requestLayout();
    }
}

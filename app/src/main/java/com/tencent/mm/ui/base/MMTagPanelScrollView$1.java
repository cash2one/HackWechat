package com.tencent.mm.ui.base;

class MMTagPanelScrollView$1 implements Runnable {
    final /* synthetic */ MMTagPanelScrollView yeg;

    MMTagPanelScrollView$1(MMTagPanelScrollView mMTagPanelScrollView) {
        this.yeg = mMTagPanelScrollView;
    }

    public final void run() {
        this.yeg.scrollTo(0, this.yeg.getBottom());
    }
}

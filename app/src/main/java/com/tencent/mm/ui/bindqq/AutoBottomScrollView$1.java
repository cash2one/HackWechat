package com.tencent.mm.ui.bindqq;

class AutoBottomScrollView$1 implements Runnable {
    final /* synthetic */ AutoBottomScrollView ymG;

    AutoBottomScrollView$1(AutoBottomScrollView autoBottomScrollView) {
        this.ymG = autoBottomScrollView;
    }

    public final void run() {
        this.ymG.smoothScrollTo(0, this.ymG.getBottom());
    }
}

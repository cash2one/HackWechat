package com.tencent.mm.ui.base;

class MMHorList$1 implements Runnable {
    final /* synthetic */ MMHorList ybQ;

    MMHorList$1(MMHorList mMHorList) {
        this.ybQ = mMHorList;
    }

    public final void run() {
        this.ybQ.requestLayout();
    }
}

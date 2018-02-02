package com.tencent.mm.ui.base;

class HorizontalListView$2 implements Runnable {
    final /* synthetic */ HorizontalListView xYh;

    HorizontalListView$2(HorizontalListView horizontalListView) {
        this.xYh = horizontalListView;
    }

    public final void run() {
        this.xYh.requestLayout();
    }
}

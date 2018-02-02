package com.tencent.mm.plugin.collect.ui;

class CollectMainUI$18 implements Runnable {
    final /* synthetic */ CollectMainUI lnh;

    CollectMainUI$18(CollectMainUI collectMainUI) {
        this.lnh = collectMainUI;
    }

    public final void run() {
        int[] iArr = new int[2];
        CollectMainUI.g(this.lnh).getLocationInWindow(iArr);
        CollectMainUI.os(iArr[1]);
    }
}

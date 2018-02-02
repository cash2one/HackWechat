package com.tencent.mm.ui.account;

class MMKeyboardUperView$2 implements Runnable {
    final /* synthetic */ MMKeyboardUperView xPQ;

    MMKeyboardUperView$2(MMKeyboardUperView mMKeyboardUperView) {
        this.xPQ = mMKeyboardUperView;
    }

    public final void run() {
        MMKeyboardUperView.a(this.xPQ).setVisibility(0);
    }
}

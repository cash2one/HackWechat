package com.tencent.mm.plugin.pwdgroup.ui.widget;

class MMKeyBoardView$1 implements Runnable {
    final /* synthetic */ MMKeyBoardView pne;

    MMKeyBoardView$1(MMKeyBoardView mMKeyBoardView) {
        this.pne = mMKeyBoardView;
    }

    public final void run() {
        this.pne.requestLayout();
    }
}

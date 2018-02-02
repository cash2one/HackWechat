package com.tencent.mm.ui.base;

import android.view.View;

class MMListPopupWindow$1 implements Runnable {
    final /* synthetic */ MMListPopupWindow ybW;

    MMListPopupWindow$1(MMListPopupWindow mMListPopupWindow) {
        this.ybW = mMListPopupWindow;
    }

    public final void run() {
        View view = this.ybW.SW;
        if (view != null && view.getWindowToken() != null) {
            this.ybW.show();
        }
    }
}

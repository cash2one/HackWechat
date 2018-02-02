package com.tencent.mm.ui.base;

class MMListPopupWindow$f implements Runnable {
    final /* synthetic */ MMListPopupWindow ybW;

    private MMListPopupWindow$f(MMListPopupWindow mMListPopupWindow) {
        this.ybW = mMListPopupWindow;
    }

    public final void run() {
        if (MMListPopupWindow.a(this.ybW) != null && MMListPopupWindow.a(this.ybW).getCount() > MMListPopupWindow.a(this.ybW).getChildCount() && MMListPopupWindow.a(this.ybW).getChildCount() <= this.ybW.ST) {
            MMListPopupWindow.b(this.ybW).setInputMethodMode(2);
            this.ybW.show();
        }
    }
}

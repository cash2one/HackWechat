package com.tencent.mm.ui.base;

class MMCollapsibleTextView$2 implements Runnable {
    final /* synthetic */ MMCollapsibleTextView xZN;

    MMCollapsibleTextView$2(MMCollapsibleTextView mMCollapsibleTextView) {
        this.xZN = mMCollapsibleTextView;
    }

    public final void run() {
        MMCollapsibleTextView.d(this.xZN).setMaxLines(10);
        MMCollapsibleTextView.e(this.xZN).setVisibility(0);
        MMCollapsibleTextView.e(this.xZN).setText(MMCollapsibleTextView.f(this.xZN));
    }
}

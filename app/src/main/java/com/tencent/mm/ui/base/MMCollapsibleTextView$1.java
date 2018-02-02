package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class MMCollapsibleTextView$1 implements OnClickListener {
    final /* synthetic */ MMCollapsibleTextView xZN;

    MMCollapsibleTextView$1(MMCollapsibleTextView mMCollapsibleTextView) {
        this.xZN = mMCollapsibleTextView;
    }

    public final void onClick(View view) {
        switch (MMCollapsibleTextView.b(this.xZN).get(MMCollapsibleTextView.a(this.xZN), -1)) {
            case 1:
                MMCollapsibleTextView.b(this.xZN).put(MMCollapsibleTextView.a(this.xZN), 2);
                break;
            case 2:
                MMCollapsibleTextView.b(this.xZN).put(MMCollapsibleTextView.a(this.xZN), 1);
                break;
            default:
                return;
        }
        MMCollapsibleTextView.c(this.xZN);
    }
}

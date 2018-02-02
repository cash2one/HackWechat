package com.tencent.mm.plugin.collect.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class CollectBillUI$2 implements OnScrollListener {
    final /* synthetic */ CollectBillUI llV;

    CollectBillUI$2(CollectBillUI collectBillUI) {
        this.llV = collectBillUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (CollectBillUI.b(this.llV).getLastVisiblePosition() == CollectBillUI.c(this.llV).getCount() && CollectBillUI.c(this.llV).getCount() > 0 && !CollectBillUI.d(this.llV) && !CollectBillUI.e(this.llV)) {
            CollectBillUI.f(this.llV);
            CollectBillUI.g(this.llV);
        }
    }
}

package com.tencent.mm.plugin.brandservice.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class BizSearchResultItemContainer$1 implements OnScrollListener {
    boolean kFO = false;
    final /* synthetic */ BizSearchResultItemContainer kFP;

    BizSearchResultItemContainer$1(BizSearchResultItemContainer bizSearchResultItemContainer) {
        this.kFP = bizSearchResultItemContainer;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.kFO && BizSearchResultItemContainer.a(this.kFP)) {
            BizSearchResultItemContainer.a(this.kFP, BizSearchResultItemContainer.b(this.kFP).fod, BizSearchResultItemContainer.b(this.kFP).offset, BizSearchResultItemContainer.c(this.kFP)[BizSearchResultItemContainer.c(this.kFP).length - 1]);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            this.kFO = true;
        } else {
            this.kFO = false;
        }
    }
}

package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class HorizontalListViewV2$2 extends DataSetObserver {
    final /* synthetic */ HorizontalListViewV2 xYC;

    HorizontalListViewV2$2(HorizontalListViewV2 horizontalListViewV2) {
        this.xYC = horizontalListViewV2;
    }

    public final void onChanged() {
        HorizontalListViewV2.b(this.xYC);
        HorizontalListViewV2.c(this.xYC);
        HorizontalListViewV2.d(this.xYC);
        this.xYC.invalidate();
        this.xYC.requestLayout();
    }

    public final void onInvalidated() {
        HorizontalListViewV2.c(this.xYC);
        HorizontalListViewV2.d(this.xYC);
        HorizontalListViewV2.e(this.xYC);
        this.xYC.invalidate();
        this.xYC.requestLayout();
    }
}

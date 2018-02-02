package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class HorizontalListView$1 extends DataSetObserver {
    final /* synthetic */ HorizontalListView xYh;

    HorizontalListView$1(HorizontalListView horizontalListView) {
        this.xYh = horizontalListView;
    }

    public final void onChanged() {
        synchronized (this.xYh) {
            HorizontalListView.a(this.xYh);
        }
        this.xYh.invalidate();
        this.xYh.requestLayout();
    }

    public final void onInvalidated() {
        HorizontalListView.b(this.xYh);
        this.xYh.invalidate();
        this.xYh.requestLayout();
    }
}

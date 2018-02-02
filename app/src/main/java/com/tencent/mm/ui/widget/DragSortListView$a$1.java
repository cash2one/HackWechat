package com.tencent.mm.ui.widget;

import android.database.DataSetObserver;
import com.tencent.mm.ui.widget.DragSortListView.a;

class DragSortListView$a$1 extends DataSetObserver {
    final /* synthetic */ DragSortListView zsr;
    final /* synthetic */ a zss;

    DragSortListView$a$1(a aVar, DragSortListView dragSortListView) {
        this.zss = aVar;
        this.zsr = dragSortListView;
    }

    public final void onChanged() {
        this.zss.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.zss.notifyDataSetInvalidated();
    }
}

package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;

class GridHeadersGridView$1 extends DataSetObserver {
    final /* synthetic */ GridHeadersGridView zfe;

    GridHeadersGridView$1(GridHeadersGridView gridHeadersGridView) {
        this.zfe = gridHeadersGridView;
    }

    public final void onChanged() {
        GridHeadersGridView.a(this.zfe);
    }

    public final void onInvalidated() {
        GridHeadersGridView.a(this.zfe);
    }
}

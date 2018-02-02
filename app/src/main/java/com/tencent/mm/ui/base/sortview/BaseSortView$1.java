package com.tencent.mm.ui.base.sortview;

import android.database.DataSetObserver;

class BaseSortView$1 extends DataSetObserver {
    final /* synthetic */ BaseSortView ykf;

    BaseSortView$1(BaseSortView baseSortView) {
        this.ykf = baseSortView;
    }

    public final void onChanged() {
        if (BaseSortView.a(this.ykf) != null) {
            BaseSortView.a(this.ykf).ai(BaseSortView.b(this.ykf).ykb);
        }
    }
}

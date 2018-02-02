package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class BaseSortView$2 implements OnItemClickListener {
    final /* synthetic */ BaseSortView ykf;

    BaseSortView$2(BaseSortView baseSortView) {
        this.ykf = baseSortView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (BaseSortView.c(this.ykf) != null) {
            BaseSortView.c(this.ykf).onItemClick(adapterView, view, i, j);
        }
    }
}

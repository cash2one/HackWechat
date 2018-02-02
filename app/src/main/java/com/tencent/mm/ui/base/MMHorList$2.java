package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class MMHorList$2 extends DataSetObserver {
    final /* synthetic */ MMHorList ybQ;

    MMHorList$2(MMHorList mMHorList) {
        this.ybQ = mMHorList;
    }

    public final void onChanged() {
        MMHorList.a(this.ybQ);
        this.ybQ.invalidate();
        this.ybQ.requestLayout();
    }

    public final void onInvalidated() {
        MMHorList.b(this.ybQ);
        this.ybQ.invalidate();
        this.ybQ.requestLayout();
    }
}

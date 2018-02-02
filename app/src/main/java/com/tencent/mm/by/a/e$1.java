package com.tencent.mm.by.a;

import android.database.DataSetObserver;

class e$1 extends DataSetObserver {
    final /* synthetic */ e xBS;

    e$1(e eVar) {
        this.xBS = eVar;
    }

    public final void onChanged() {
        e.a(this.xBS);
    }

    public final void onInvalidated() {
        e.b(this.xBS);
    }
}

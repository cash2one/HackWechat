package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;

final class f$a extends DataSetObserver {
    final /* synthetic */ f zfn;

    private f$a(f fVar) {
        this.zfn = fVar;
    }

    public final void onChanged() {
        f.a(this.zfn, this.zfn.a(f.a(this.zfn)));
        this.zfn.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        f.a(this.zfn, this.zfn.a(f.a(this.zfn)));
        this.zfn.notifyDataSetInvalidated();
    }
}

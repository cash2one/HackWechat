package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

class a$2 extends RecentsRecyclerView {
    final /* synthetic */ a jPj;

    a$2(a aVar, Context context) {
        this.jPj = aVar;
        super(context);
    }

    protected final LinearLayoutManager alq() {
        return a.n(this.jPj);
    }
}

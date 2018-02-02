package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.t;

class k$a extends c {
    private k$a() {
    }

    public final c b(t tVar, int i) {
        super.b(tVar, i);
        this.UZ = i;
        return this;
    }

    final boolean alD() {
        return (this.UZ & 2048) > 0;
    }
}

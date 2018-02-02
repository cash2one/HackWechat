package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.p;

class a$15 extends LinearLayoutManager {
    final /* synthetic */ a jPj;

    a$15(a aVar) {
        this.jPj = aVar;
        super(1, false);
    }

    public final void a(RecyclerView recyclerView, int i) {
        p lVar = new l(this.jPj.getActivity(), a.n(this.jPj));
        lVar.Vv = i;
        a(lVar);
    }

    public final boolean eP() {
        return false;
    }
}

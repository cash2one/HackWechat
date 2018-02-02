package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;

class k$2 extends an {
    final /* synthetic */ t Rd;
    final /* synthetic */ ai Re;
    final /* synthetic */ k jRl;

    k$2(k kVar, t tVar, ai aiVar) {
        this.jRl = kVar;
        this.Rd = tVar;
        this.Re = aiVar;
    }

    public final void p(View view) {
        ((RecentsRecyclerView) view.getParent()).bN(view);
        this.jRl.z(this.Rd);
    }

    public final void q(View view) {
        if (view != null) {
            ((RecentsRecyclerView) view.getParent()).bO(view);
            this.Re.a(null);
            z.c(view, 0.0f);
            this.jRl.k(this.Rd);
            this.jRl.jQX.remove(this.Rd);
            k.a(this.jRl);
        }
    }

    public final void ar(View view) {
        if (view != null) {
            z.c(view, 0.0f);
            z.d(view, 1.0f);
        }
    }
}

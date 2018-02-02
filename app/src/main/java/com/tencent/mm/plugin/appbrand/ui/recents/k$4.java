package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

class k$4 extends an {
    final /* synthetic */ ai Re;
    final /* synthetic */ k jRl;
    final /* synthetic */ d jRm;

    k$4(k kVar, d dVar, ai aiVar) {
        this.jRl = kVar;
        this.jRm = dVar;
        this.Re = aiVar;
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        this.Re.a(null);
        this.jRl.k(this.jRm);
        this.jRl.jRb.remove(this.jRm);
        k.a(this.jRl);
    }

    public final void ar(View view) {
        if (view != null) {
            z.c(view, 0.0f);
            z.d(view, 1.0f);
        }
    }
}

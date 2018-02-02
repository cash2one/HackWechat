package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

class k$5 extends an {
    final /* synthetic */ k jRl;
    final /* synthetic */ d jRm;

    k$5(k kVar, d dVar) {
        this.jRl = kVar;
        this.jRm = dVar;
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        z.e(this.jRm.jPA, 1.0f);
        z.f(this.jRm.jPA, 1.0f);
        z.d(this.jRm.jPA, 1.0f);
        this.jRm.jPA.setVisibility(8);
        this.jRl.k(this.jRm);
        this.jRl.jRd.remove(this.jRm);
        k.a(this.jRl);
    }
}

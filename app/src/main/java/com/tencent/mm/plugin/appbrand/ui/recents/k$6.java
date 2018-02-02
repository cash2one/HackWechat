package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;

class k$6 extends an {
    final /* synthetic */ k jRl;
    final /* synthetic */ a$d jRm;

    k$6(k kVar, a$d com_tencent_mm_plugin_appbrand_ui_recents_a_d) {
        this.jRl = kVar;
        this.jRm = com_tencent_mm_plugin_appbrand_ui_recents_a_d;
    }

    public final void p(View view) {
        this.jRl.z(this.jRm);
    }

    public final void q(View view) {
        z.c(view, 0.0f);
        z.d(view, 1.0f);
        this.jRl.k(this.jRm);
        this.jRl.jRf.remove(this.jRm);
        k.a(this.jRl);
    }
}

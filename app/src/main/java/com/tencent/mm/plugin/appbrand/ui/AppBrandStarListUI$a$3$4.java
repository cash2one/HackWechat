package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.3;

class AppBrandStarListUI$a$3$4 implements Runnable {
    final /* synthetic */ t jMl;
    final /* synthetic */ 3 jMm;

    AppBrandStarListUI$a$3$4(3 3, t tVar) {
        this.jMm = 3;
        this.jMl = tVar;
    }

    public final void run() {
        this.jMm.jMk.remove(this.jMl);
        3.a(this.jMm, this.jMl);
    }
}

package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.t;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f;

class AppBrandStarListUI$a$3$3 implements Runnable {
    final /* synthetic */ t jMl;
    final /* synthetic */ 3 jMm;
    final /* synthetic */ f jMn;

    AppBrandStarListUI$a$3$3(3 3, f fVar, t tVar) {
        this.jMm = 3;
        this.jMn = fVar;
        this.jMl = tVar;
    }

    public final void run() {
        this.jMn.jMy.setVisibility(8);
        this.jMm.jMj.remove(this.jMl);
        3.a(this.jMm, this.jMl);
    }
}

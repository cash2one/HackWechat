package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f;

class AppBrandStarListUI$a$f$1 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ int iJO;
    final /* synthetic */ f jMz;
    final /* synthetic */ int kI;

    AppBrandStarListUI$a$f$1(f fVar, String str, int i, int i2) {
        this.jMz = fVar;
        this.gIT = str;
        this.iJO = i;
        this.kI = i2;
    }

    public final void run() {
        com.tencent.mm.plugin.appbrand.app.f.Zn().h(this.gIT, this.iJO, true);
        if (this.jMz.jMg.getActivity() != null) {
            this.jMz.jMg.getActivity().runOnUiThread(new 1(this));
        }
        a.a(this.jMz.jMu.appId, this.jMz.jMu.iGA + 1, 4, 2, "");
    }
}

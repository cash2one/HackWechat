package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f.1;
import com.tencent.mm.sdk.platformtools.bh;

class AppBrandStarListUI$a$f$1$1 implements Runnable {
    final /* synthetic */ 1 jMA;

    AppBrandStarListUI$a$f$1$1(1 1) {
        this.jMA = 1;
    }

    public final void run() {
        this.jMA.jMz.jMg.jMd.remove(this.jMA.kI);
        if (this.jMA.jMz.jMg.jLY != null) {
            this.jMA.jMz.jMg.jLY.bl(this.jMA.kI);
            this.jMA.jMz.jMg.akO();
            if (bh.cA(this.jMA.jMz.jMg.jMd)) {
                AppBrandStarListUI.a((AppBrandStarListUI) this.jMA.jMz.jMg.getActivity());
            }
        }
    }
}

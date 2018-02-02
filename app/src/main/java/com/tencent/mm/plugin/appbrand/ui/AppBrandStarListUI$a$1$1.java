package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Collection;
import java.util.List;

class AppBrandStarListUI$a$1$1 implements Runnable {
    final /* synthetic */ List jMh;
    final /* synthetic */ 1 jMi;

    AppBrandStarListUI$a$1$1(1 1, List list) {
        this.jMi = 1;
        this.jMh = list;
    }

    public final void run() {
        if (this.jMi.jMg.getActivity() != null) {
            if (bh.cA(this.jMh)) {
                AppBrandStarListUI.a((AppBrandStarListUI) this.jMi.jMg.getActivity());
                return;
            }
            a aVar = this.jMi.jMg;
            Collection collection = this.jMh;
            aVar.jMd.clear();
            aVar.jMd.addAll(collection);
            aVar.a(c.jMs);
            aVar.akO();
        }
    }
}

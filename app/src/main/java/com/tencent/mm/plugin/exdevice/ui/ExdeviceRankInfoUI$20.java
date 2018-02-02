package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.base.p.d;

class ExdeviceRankInfoUI$20 implements d {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$20(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                com.tencent.mm.plugin.sport.b.d.pY(15);
                ExdeviceRankInfoUI.n(this.lXj);
                return;
            case 1:
                com.tencent.mm.plugin.sport.b.d.pY(16);
                ExdeviceRankInfoUI.m(this.lXj);
                return;
            case 2:
                com.tencent.mm.plugin.sport.b.d.pY(7);
                ExdeviceRankInfoUI.o(this.lXj);
                return;
            case 3:
                com.tencent.mm.plugin.sport.b.d.pY(36);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1063;
                ((c) g.h(c.class)).a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, appBrandStatObject);
                return;
            default:
                return;
        }
    }
}

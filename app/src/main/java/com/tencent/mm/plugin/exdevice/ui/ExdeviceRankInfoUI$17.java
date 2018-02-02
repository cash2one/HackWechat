package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.ui.base.p.d;

class ExdeviceRankInfoUI$17 implements d {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$17(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (i) {
            case 0:
                ExdeviceRankInfoUI.a(this.lXj, true);
                com.tencent.mm.plugin.sport.b.d.pY(10);
                ad.aEs();
                c.b("", ExdeviceRankInfoUI.x(this.lXj), ExdeviceRankInfoUI.y(this.lXj).field_username, 3);
                return;
            default:
                return;
        }
    }
}

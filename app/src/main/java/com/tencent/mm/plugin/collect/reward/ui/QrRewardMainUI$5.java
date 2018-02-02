package com.tencent.mm.plugin.collect.reward.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class QrRewardMainUI$5 implements d {
    final /* synthetic */ QrRewardMainUI lkA;

    QrRewardMainUI$5(QrRewardMainUI qrRewardMainUI) {
        this.lkA = qrRewardMainUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                QrRewardMainUI.a(this.lkA, "");
                QrRewardMainUI.n(this.lkA);
                QrRewardMainUI.c(this.lkA, true);
                g.pQN.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(3)});
                return;
            case 2:
                QrRewardMainUI.c(this.lkA, false);
                QrRewardMainUI.o(this.lkA);
                g.pQN.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(4)});
                return;
            default:
                x.i("MicroMsg.QrRewardMainUI", "unknown menu: %s", new Object[]{Integer.valueOf(menuItem.getItemId())});
                QrRewardMainUI.c(this.lkA, true);
                return;
        }
    }
}

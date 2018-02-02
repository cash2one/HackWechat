package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.report.service.g;

class HomeUI$7 implements Runnable {
    final /* synthetic */ HomeUI xGv;

    HomeUI$7(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void run() {
        if (!a.aV(HomeUI.d(this.xGv)) || a.aU(HomeUI.d(this.xGv))) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            g.pQN.h(11409, new Object[0]);
            d.b(HomeUI.d(this.xGv), "scanner", ".ui.BaseScanUI", intent);
        }
    }
}

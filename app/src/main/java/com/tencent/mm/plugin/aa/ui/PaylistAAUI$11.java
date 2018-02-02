package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.plugin.report.service.g;

class PaylistAAUI$11 implements a {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$11(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final void WO() {
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", 0);
        d.b(this.ikp, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        g.pQN.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
    }
}

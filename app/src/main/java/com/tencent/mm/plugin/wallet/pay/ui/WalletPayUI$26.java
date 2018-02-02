package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.c.t;

class WalletPayUI$26 extends r {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$26(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void ayX() {
        p.bJN();
        if (!p.bJO().bLN()) {
            t.d(this.sGh.sEO == null ? 0 : this.sGh.sEO.fCV, this.sGh.sEO == null ? "" : this.sGh.sEO.fuH, 6, "");
        }
        this.sGh.bKo();
    }
}

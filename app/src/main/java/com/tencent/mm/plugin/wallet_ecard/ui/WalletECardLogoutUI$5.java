package com.tencent.mm.plugin.wallet_ecard.ui;

import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.wallet_core.ui.e;

class WalletECardLogoutUI$5 implements a {
    final /* synthetic */ WalletECardLogoutUI sZX;
    final /* synthetic */ boe sZZ;

    WalletECardLogoutUI$5(WalletECardLogoutUI walletECardLogoutUI, boe com_tencent_mm_protocal_c_boe) {
        this.sZX = walletECardLogoutUI;
        this.sZZ = com_tencent_mm_protocal_c_boe;
    }

    public final void aze() {
        e.l(this.sZX.mController.xIM, this.sZZ.vZl, false);
    }
}

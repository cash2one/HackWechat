package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ak.b.a;

class WalletOrderInfoOldUI$6 implements a {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    WalletOrderInfoOldUI$6(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
    }

    public final void v(String str, boolean z) {
        x WO = ((h) g.h(h.class)).EY().WO(str);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + str + " succ: " + z);
        this.sUK.K(WO);
    }
}

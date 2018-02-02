package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ak.b.a;

class WalletOrderInfoUI$1 implements a {
    final /* synthetic */ WalletOrderInfoUI sVh;

    WalletOrderInfoUI$1(WalletOrderInfoUI walletOrderInfoUI) {
        this.sVh = walletOrderInfoUI;
    }

    public final void v(String str, boolean z) {
        g.Dk();
        x WO = ((h) g.h(h.class)).EY().WO(str);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
        this.sVh.K(WO);
    }
}

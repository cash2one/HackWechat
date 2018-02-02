package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.g.a.sr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletIapUI$4 extends c<sr> {
    final /* synthetic */ WalletIapUI tbh;

    WalletIapUI$4(WalletIapUI walletIapUI) {
        this.tbh = walletIapUI;
        this.xen = sr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sr srVar = (sr) bVar;
        x.i("MicroMsg.WalletIapUI", "payListener callback to close progress");
        if (srVar instanceof sr) {
            if (WalletIapUI.c(this.tbh) != null && WalletIapUI.c(this.tbh).isShowing()) {
                WalletIapUI.c(this.tbh).dismiss();
                WalletIapUI.d(this.tbh);
            }
            return true;
        }
        x.f("MicroMsg.WalletIapUI", "mismatched event");
        return false;
    }
}

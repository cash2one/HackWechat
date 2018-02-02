package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.g.a.sr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WalletBrandUI$3 extends c<sr> {
    final /* synthetic */ WalletBrandUI tbb;

    WalletBrandUI$3(WalletBrandUI walletBrandUI) {
        this.tbb = walletBrandUI;
        this.xen = sr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (WalletBrandUI.a(this.tbb) != null) {
            WalletBrandUI.a(this.tbb).dismiss();
            WalletBrandUI.b(this.tbb);
        }
        return true;
    }
}

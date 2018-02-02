package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.tg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletPayUI$1 extends c<tg> {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$1(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
        this.xen = tg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WalletPayUI", "WalletRealNameResultNotifyMoreEvent %s", new Object[]{Integer.valueOf(((tg) bVar).fLJ.result)});
        if (((tg) bVar).fLJ.result == -1) {
            WalletPayUI.a(this.sGh);
            WalletPayUI.b(this.sGh);
            this.sGh.bKi();
        }
        return false;
    }
}

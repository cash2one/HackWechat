package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.mm.g.a.ac;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.9;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletBankcardManageUI$9$1 extends c<ac> {
    final /* synthetic */ 9 sCJ;
    final /* synthetic */ Bankcard syX;

    WalletBankcardManageUI$9$1(9 9, Bankcard bankcard) {
        this.sCJ = 9;
        this.syX = bankcard;
        this.xen = ac.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        a.xef.c(this);
        x.i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
        this.sCJ.sCF.b(this.syX);
        return true;
    }
}

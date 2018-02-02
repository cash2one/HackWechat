package com.tencent.mm.plugin.wallet_payu.pay.ui;

import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;

class WalletPayUPayUI$1 implements b {
    final /* synthetic */ WalletPayUPayUI tcY;

    WalletPayUPayUI$1(WalletPayUPayUI walletPayUPayUI) {
        this.tcY = walletPayUPayUI;
    }

    public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
        this.tcY.aWs();
        WalletPayUPayUI.a(this.tcY, str);
        WalletPayUPayUI.b(this.tcY, str2);
        this.tcY.jF(false);
        c.bNg();
    }
}

package com.tencent.mm.plugin.wallet_payu.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;

class WalletPayUChangeBankcardUI$1 implements b {
    final /* synthetic */ WalletPayUChangeBankcardUI tcW;

    WalletPayUChangeBankcardUI$1(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        this.tcW = walletPayUChangeBankcardUI;
    }

    public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
        WalletPayUChangeBankcardUI.a(this.tcW, favorPayInfo);
        this.tcW.vf.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(this.tcW));
        WalletPayUChangeBankcardUI.a(this.tcW, str);
        WalletPayUChangeBankcardUI.b(this.tcW, str2);
        this.tcW.aWs();
        this.tcW.MM(str);
    }
}

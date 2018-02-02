package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.m.c;

class WalletChangeBankcardUI$5 implements c {
    final /* synthetic */ WalletChangeBankcardUI sEU;

    WalletChangeBankcardUI$5(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.sEU = walletChangeBankcardUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        this.sEU.sEQ = favorPayInfo;
        this.sEU.vf.putParcelable("key_favor_pay_info", this.sEU.sEQ);
        if (this.sEU.sEQ == null || !z) {
            this.sEU.mzL = str;
            this.sEU.aWs();
            this.sEU.MM(str);
            this.sEU.sES = null;
            return;
        }
        if (this.sEU.sEQ != null) {
            this.sEU.jC(true);
            this.sEU.sEN.d(this.sEU.szk, false);
        }
        if (this.sEU.szh != null) {
            this.sEU.szh.dismiss();
        }
        this.sEU.au();
        this.sEU.uD(0);
    }
}

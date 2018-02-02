package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletPayUStartOpenUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUStartOpenUI tcq;

    WalletPayUStartOpenUI$2(WalletPayUStartOpenUI walletPayUStartOpenUI) {
        this.tcq = walletPayUStartOpenUI;
    }

    public final void onClick(View view) {
        if (WalletPayUStartOpenUI.b(this.tcq).getVisibility() == 0) {
            this.tcq.vf.putString("key_mobile", WalletPayUStartOpenUI.c(this.tcq));
            this.tcq.vf.putString("dial_code", WalletPayUStartOpenUI.d(this.tcq));
        }
        this.tcq.cCd().k(new Object[0]);
    }
}

package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletBindDepositUI$2 implements OnClickListener {
    final /* synthetic */ WalletBindDepositUI tZz;

    WalletBindDepositUI$2(WalletBindDepositUI walletBindDepositUI) {
        this.tZz = walletBindDepositUI;
    }

    public final void onClick(View view) {
        if (WalletBindDepositUI.e(this.tZz)) {
            this.tZz.cCd().k(new Object[]{WalletBindDepositUI.a(this.tZz).getText(), WalletBindDepositUI.d(this.tZz).oZz, WalletBindDepositUI.f(this.tZz).getText(), WalletBindDepositUI.d(this.tZz).sMC, Boolean.valueOf(false)});
        }
    }
}

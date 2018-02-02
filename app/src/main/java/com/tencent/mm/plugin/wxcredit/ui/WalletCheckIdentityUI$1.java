package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletCheckIdentityUI$1 implements OnClickListener {
    final /* synthetic */ WalletCheckIdentityUI tZB;

    WalletCheckIdentityUI$1(WalletCheckIdentityUI walletCheckIdentityUI) {
        this.tZB = walletCheckIdentityUI;
    }

    public final void onClick(View view) {
        if (WalletCheckIdentityUI.a(this.tZB, WalletCheckIdentityUI.a(this.tZB).getText(), WalletCheckIdentityUI.b(this.tZB).getText())) {
            this.tZB.cCd().k(new Object[]{r0, r1});
        }
    }
}

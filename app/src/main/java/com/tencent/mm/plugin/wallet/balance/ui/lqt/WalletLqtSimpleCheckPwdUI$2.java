package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletLqtSimpleCheckPwdUI$2 implements a {
    final /* synthetic */ WalletLqtSimpleCheckPwdUI sBI;

    WalletLqtSimpleCheckPwdUI$2(WalletLqtSimpleCheckPwdUI walletLqtSimpleCheckPwdUI) {
        this.sBI = walletLqtSimpleCheckPwdUI;
    }

    public final void hx(boolean z) {
        if (z) {
            WalletLqtSimpleCheckPwdUI.a(this.sBI, new r(WalletLqtSimpleCheckPwdUI.a(this.sBI).getText(), 7, this.sBI.bJQ()));
            this.sBI.r(WalletLqtSimpleCheckPwdUI.b(this.sBI));
        }
    }
}

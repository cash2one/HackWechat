package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletSetPasswordUI$1 implements a {
    final /* synthetic */ WalletSetPasswordUI sWr;

    WalletSetPasswordUI$1(WalletSetPasswordUI walletSetPasswordUI) {
        this.sWr = walletSetPasswordUI;
    }

    public final void hx(boolean z) {
        if (z) {
            String cCk = this.sWr.sBG.cCk();
            Bundle bundle = new Bundle();
            bundle.putString("key_new_pwd1", cCk);
            this.sWr.sBG.bmK();
            com.tencent.mm.wallet_core.a.j(this.sWr, bundle);
        }
    }
}

package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.a;

class WalletCheckPwdUI$5 implements a {
    final /* synthetic */ WalletCheckPwdUI sTs;

    WalletCheckPwdUI$5(WalletCheckPwdUI walletCheckPwdUI) {
        this.sTs = walletCheckPwdUI;
    }

    public final void hA(boolean z) {
        x.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[]{Boolean.valueOf(z)});
        WalletCheckPwdUI.h(this.sTs).post(new 1(this, z));
    }
}

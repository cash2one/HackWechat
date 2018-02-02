package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.ta;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletPwdConfirmUI$4 extends c<ta> {
    final /* synthetic */ WalletPwdConfirmUI sVm;

    WalletPwdConfirmUI$4(WalletPwdConfirmUI walletPwdConfirmUI) {
        this.sVm = walletPwdConfirmUI;
        this.xen = ta.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ta) bVar) instanceof ta) {
            x.d("Micromsg.WalletPwdConfirmUI", "event WalletPwdConfirmDoSecondaryProgressCallbackEvent");
            WalletPwdConfirmUI.d(this.sVm);
            WalletPwdConfirmUI.e(this.sVm);
        }
        return false;
    }
}

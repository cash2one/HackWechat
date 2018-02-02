package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.g.a.bo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.5;
import com.tencent.mm.plugin.wallet_core.c.x;

class WalletPasswordSettingUI$5$1 implements Runnable {
    final /* synthetic */ bo myX;
    final /* synthetic */ 5 sHs;

    WalletPasswordSettingUI$5$1(5 5, bo boVar) {
        this.sHs = 5;
        this.myX = boVar;
    }

    public final void run() {
        if (this.myX.fpI == null) {
            return;
        }
        if (this.myX.fpI.retCode == 0) {
            WalletPasswordSettingUI.d(this.sHs.sHq);
            g.Dk();
            g.Di().gPJ.a(new x(null, 19), 0);
            return;
        }
        WalletPasswordSettingUI.e(this.sHs.sHq);
        WalletPasswordSettingUI.f(this.sHs.sHq);
    }
}

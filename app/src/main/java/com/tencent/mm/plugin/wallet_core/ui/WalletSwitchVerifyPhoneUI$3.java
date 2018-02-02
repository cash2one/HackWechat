package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.g.a;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.platformtools.x;

class WalletSwitchVerifyPhoneUI$3 implements a {
    final /* synthetic */ WalletSwitchVerifyPhoneUI sWv;
    final /* synthetic */ ew sWw;

    WalletSwitchVerifyPhoneUI$3(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, ew ewVar) {
        this.sWv = walletSwitchVerifyPhoneUI;
        this.sWw = ewVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
        WalletSwitchVerifyPhoneUI.a(this.sWv, this.sWw);
    }
}

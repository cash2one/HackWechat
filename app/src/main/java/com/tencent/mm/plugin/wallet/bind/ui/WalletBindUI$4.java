package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.wallet_core.c.a;

class WalletBindUI$4 implements a {
    final /* synthetic */ WalletBindUI sCR;

    WalletBindUI$4(WalletBindUI walletBindUI) {
        this.sCR = walletBindUI;
    }

    public final Intent l(int i, Bundle bundle) {
        return new Intent(this.sCR.mController.xIM, WalletBankcardManageUI.class);
    }
}

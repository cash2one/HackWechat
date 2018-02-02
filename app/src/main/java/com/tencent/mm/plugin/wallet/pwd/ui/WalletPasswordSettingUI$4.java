package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.su;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c$a;

class WalletPasswordSettingUI$4 implements c$a {
    final /* synthetic */ WalletPasswordSettingUI sHq;

    WalletPasswordSettingUI$4(WalletPasswordSettingUI walletPasswordSettingUI) {
        this.sHq = walletPasswordSettingUI;
    }

    public final Intent l(int i, Bundle bundle) {
        x.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
        b suVar = new su();
        if (i == -1) {
            suVar.fKE.scene = 17;
        } else if (i == 0) {
            suVar.fKE.scene = 18;
        } else {
            suVar.fKE.scene = 0;
        }
        suVar.fKF.fKz = new 1(this);
        a.xef.m(suVar);
        return null;
    }
}

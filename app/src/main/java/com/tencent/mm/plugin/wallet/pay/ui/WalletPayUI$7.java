package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.m.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.t;

class WalletPayUI$7 implements c {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$7(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        String str2;
        this.sGh.aWs();
        this.sGh.sEQ = favorPayInfo;
        String str3 = "MicroMsg.WalletPayUI";
        String str4 = "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s";
        Object[] objArr = new Object[2];
        if (this.sGh.sEQ == null) {
            str2 = "";
        } else {
            str2 = this.sGh.sEQ.toString();
        }
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(z);
        x.i(str3, str4, objArr);
        if (this.sGh.sEQ == null || !z) {
            t.d(this.sGh.sEO == null ? 0 : this.sGh.sEO.fCV, this.sGh.sEO == null ? "" : this.sGh.sEO.fuH, 9, "");
            this.sGh.mzL = str;
            this.sGh.jF(false);
            com.tencent.mm.plugin.wallet_core.e.c.bNg();
            this.sGh.sES = null;
            return;
        }
        this.sGh.Q(-100, true);
    }
}

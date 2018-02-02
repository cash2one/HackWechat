package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletBindCardResultUI$5 implements OnClickListener {
    final /* synthetic */ WalletBindCardResultUI sRR;

    WalletBindCardResultUI$5(WalletBindCardResultUI walletBindCardResultUI) {
        this.sRR = walletBindCardResultUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", WalletBindCardResultUI.c(this.sRR), WalletBindCardResultUI.d(this.sRR), Integer.valueOf(WalletBindCardResultUI.e(this.sRR)));
        this.sRR.gI(2);
        b qpVar = new qp();
        qpVar.fIi.userName = WalletBindCardResultUI.c(this.sRR);
        qpVar.fIi.fIk = bh.az(WalletBindCardResultUI.d(this.sRR), "");
        qpVar.fIi.scene = 1034;
        qpVar.fIi.fIl = 0;
        if (WalletBindCardResultUI.e(this.sRR) > 0) {
            qpVar.fIi.fIm = WalletBindCardResultUI.e(this.sRR);
        }
        a.xef.m(qpVar);
        if (bh.ov(WalletBindCardResultUI.f(this.sRR).sLU.sNC) || WalletBindCardResultUI.f(this.sRR).sLS.sIr <= 0) {
            WalletBindCardResultUI.a(this.sRR, false);
        } else {
            WalletBindCardResultUI.a(this.sRR, true);
        }
    }
}

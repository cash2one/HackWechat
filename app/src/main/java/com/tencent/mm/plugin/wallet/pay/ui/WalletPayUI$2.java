package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.t;

class WalletPayUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$2(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void onClick(View view) {
        int i = 0;
        p.bJN();
        if (p.bJO().bLN()) {
            t.d(this.sGh.sEO == null ? 0 : this.sGh.sEO.fCV, this.sGh.sEO == null ? "" : this.sGh.sEO.fuH, 6, "");
        }
        if (this.sGh.pPl.sNY == 1) {
            p.bJN();
            if (p.bJO().bLN()) {
                if (this.sGh.sEO != null) {
                    i = this.sGh.sEO.fCV;
                }
                t.d(i, this.sGh.sEO == null ? "" : this.sGh.sEO.fuH, 5, "");
            }
            WalletPayUI.d(this.sGh);
            return;
        }
        x.i("MicroMsg.WalletPayUI", "SimpleReg , assigned userinfo pay! payWithNewBankcard");
        p.bJN();
        if (p.bJO().bLN()) {
            t.d(this.sGh.sEO == null ? 0 : this.sGh.sEO.fCV, this.sGh.sEO == null ? "" : this.sGh.sEO.fuH, 5, "");
        }
        this.sGh.b(false, 0, "");
    }
}

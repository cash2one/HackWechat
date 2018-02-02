package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.wallet_core.c.t;

class WalletPayUI$8 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$8(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void onClick(View view) {
        this.sGh.sEQ = (FavorPayInfo) view.getTag();
        if (this.sGh.sEQ != null) {
            this.sGh.sEQ.sMX = "";
        }
        t.d(this.sGh.sEO == null ? 0 : this.sGh.sEO.fCV, this.sGh.sEO == null ? "" : this.sGh.sEO.fuH, 10, "");
        this.sGh.c(false, 0, "");
        this.sGh.szh.dismiss();
        this.sGh.mzL = null;
        this.sGh.szh = null;
        this.sGh.sES = null;
    }
}

package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;

class WalletChangeBankcardUI$6 implements OnClickListener {
    final /* synthetic */ WalletChangeBankcardUI sEU;

    WalletChangeBankcardUI$6(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.sEU = walletChangeBankcardUI;
    }

    public final void onClick(View view) {
        if (this.sEU.szh != null) {
            this.sEU.szh.dismiss();
        }
        this.sEU.jC(false);
        this.sEU.sEN.d(this.sEU.szk, true);
        this.sEU.sEQ = (FavorPayInfo) view.getTag();
        if (this.sEU.sEQ != null) {
            this.sEU.sEQ.sMX = "";
        }
        this.sEU.vf.putParcelable("key_favor_pay_info", this.sEU.sEQ);
        this.sEU.au();
        this.sEU.uD(0);
        this.sEU.sES = null;
    }
}

package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;

class WalletPayUPayUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUPayUI tcY;

    WalletPayUPayUI$2(WalletPayUPayUI walletPayUPayUI) {
        this.tcY = walletPayUPayUI;
    }

    public final void onClick(View view) {
        WalletPayUPayUI.a(this.tcY, (FavorPayInfo) view.getTag());
        if (WalletPayUPayUI.a(this.tcY) != null) {
            WalletPayUPayUI.b(this.tcY).sMX = "";
        }
        WalletPayUPayUI.c(this.tcY, "");
        WalletPayUPayUI.c(this.tcY).dismiss();
        WalletPayUPayUI.d(this.tcY);
        WalletPayUPayUI.e(this.tcY);
    }
}

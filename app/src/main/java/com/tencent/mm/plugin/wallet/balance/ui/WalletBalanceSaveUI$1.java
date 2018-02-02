package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;

class WalletBalanceSaveUI$1 implements OnClickListener {
    final /* synthetic */ WalletBalanceSaveUI sAi;

    WalletBalanceSaveUI$1(WalletBalanceSaveUI walletBalanceSaveUI) {
        this.sAi = walletBalanceSaveUI;
    }

    public final void onClick(View view) {
        this.sAi.pLR = bh.getDouble(this.sAi.llY.getText(), 0.0d);
        if (this.sAi.pLR <= 0.0d || !this.sAi.llY.XO()) {
            u.makeText(this.sAi.mController.xIM, a$i.uPA, 0).show();
        } else {
            this.sAi.bJy();
        }
    }
}

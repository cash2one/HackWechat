package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.e;

class WalletPayUI$25 implements OnClickListener {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$25(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void onClick(View view) {
        if (this.sGh.sFE) {
            this.sGh.sFN.setImageResource(e.uds);
            this.sGh.sFE = false;
        } else {
            this.sGh.sFN.setImageResource(e.udt);
            this.sGh.sFE = true;
        }
        this.sGh.sFR.notifyDataSetChanged();
    }
}

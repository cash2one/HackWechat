package com.tencent.mm.plugin.wallet_payu.balance.ui;

import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    protected final void initView() {
        super.initView();
        this.sAf.setVisibility(8);
    }

    protected final void au() {
        if (this.pPl != null) {
            this.sAd.setText(e.d(this.pPl.pNX, this.pPl.paz));
            if (this.sAg != null && !bh.ov(this.sAg.field_bankName)) {
                if (bh.ov(this.sAg.field_bankcardTail)) {
                    this.pHJ.setText(this.sAg.field_bankName);
                } else {
                    this.pHJ.setText(this.sAg.field_bankName + " " + getString(i.uUJ) + this.sAg.field_bankcardTail);
                }
            }
        }
    }
}

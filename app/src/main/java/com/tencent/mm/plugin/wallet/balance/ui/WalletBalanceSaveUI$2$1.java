package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.2;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

class WalletBalanceSaveUI$2$1 implements a {
    final /* synthetic */ 2 sAj;

    WalletBalanceSaveUI$2$1(2 2) {
        this.sAj = 2;
    }

    public final void vm(int i) {
        if (this.sAj.sAi.szk == null || i < 0 || i >= this.sAj.sAi.szk.size()) {
            this.sAj.sAi.szl = null;
        } else {
            this.sAj.sAi.szl = (Bankcard) this.sAj.sAi.szk.get(i);
        }
        if (!(this.sAj.sAi.szl == null || bh.ov(this.sAj.sAi.szl.field_forbidWord))) {
            h.a(this.sAj.sAi.mController.xIM, this.sAj.sAi.getString(i.uPz), "", this.sAj.sAi.getString(i.dFU), new 1(this));
            this.sAj.sAi.szl = null;
        }
        this.sAj.sAi.au();
    }
}

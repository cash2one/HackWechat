package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.3;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.h$a;

class WalletPayDeductUI$3$1 implements h$a {
    final /* synthetic */ 3 sFw;

    WalletPayDeductUI$3$1(3 3) {
        this.sFw = 3;
    }

    public final void vm(int i) {
        WalletPayDeductUI.a(this.sFw.sFu, (Bankcard) this.sFw.sFv.get(i));
        WalletPayDeductUI.c(this.sFw.sFu);
    }
}

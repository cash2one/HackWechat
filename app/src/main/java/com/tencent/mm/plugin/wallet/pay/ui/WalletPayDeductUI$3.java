package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.g.a;
import com.tencent.mm.plugin.wallet_core.ui.h;
import java.util.List;

class WalletPayDeductUI$3 implements a {
    final /* synthetic */ WalletPayDeductUI sFu;
    final /* synthetic */ List sFv;

    WalletPayDeductUI$3(WalletPayDeductUI walletPayDeductUI, List list) {
        this.sFu = walletPayDeductUI;
        this.sFv = list;
    }

    public final void onClick(View view) {
        h.a(this.sFu.mController.xIM, this.sFv, null, WalletPayDeductUI.a(this.sFu), WalletPayDeductUI.b(this.sFu), new 1(this));
    }
}

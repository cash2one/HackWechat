package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.wallet_core.ui.e;

class WalletOrderInfoOldUI$10 implements OnClickListener {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    WalletOrderInfoOldUI$10(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
    }

    public final void onClick(View view) {
        e.l(this.sUK, ((Commodity) this.sUK.sEs.sNW.get(0)).sOu.url, false);
    }
}

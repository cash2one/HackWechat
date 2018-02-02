package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.ui.e;

class WalletBalanceManagerUI$11 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI szV;
    final /* synthetic */ ag szW;

    WalletBalanceManagerUI$11(WalletBalanceManagerUI walletBalanceManagerUI, ag agVar) {
        this.szV = walletBalanceManagerUI;
        this.szW = agVar;
    }

    public final void onClick(View view) {
        g.Dk();
        g.Dj().CU().a(a.xvT, Integer.valueOf(-1));
        e.l(this.szV, this.szW.bLU(), true);
    }
}

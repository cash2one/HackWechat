package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardManageUI$4 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI sCF;

    WalletBankcardManageUI$4(WalletBankcardManageUI walletBankcardManageUI) {
        this.sCF = walletBankcardManageUI;
    }

    public final void onClick(View view) {
        this.sCF.bJH();
        e.HF(19);
        g.pQN.h(14422, new Object[]{Integer.valueOf(2)});
    }
}

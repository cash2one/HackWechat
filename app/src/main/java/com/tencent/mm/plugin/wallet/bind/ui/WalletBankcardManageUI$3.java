package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;

class WalletBankcardManageUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBankcardManageUI sCF;

    WalletBankcardManageUI$3(WalletBankcardManageUI walletBankcardManageUI) {
        this.sCF = walletBankcardManageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sCF.finish();
        g.pQN.h(14422, new Object[]{Integer.valueOf(4)});
        return true;
    }
}

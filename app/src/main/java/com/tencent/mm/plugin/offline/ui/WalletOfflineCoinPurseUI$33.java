package com.tencent.mm.plugin.offline.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class WalletOfflineCoinPurseUI$33 implements OnMenuItemClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$33(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        b giVar = new gi();
        giVar.fwu.fwv = "ok";
        a.xef.m(giVar);
        this.oYH.finish();
        return false;
    }
}

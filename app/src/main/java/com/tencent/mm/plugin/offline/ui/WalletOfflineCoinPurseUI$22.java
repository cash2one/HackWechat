package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;

class WalletOfflineCoinPurseUI$22 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$22(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final void onClick(View view) {
        a.g(this.oYH, WalletOfflineCoinPurseUI.H(this.oYH));
        this.oYH.finish();
    }
}

package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOfflineCoinPurseUI$2 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$2(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oYH.finish();
    }
}

package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOfflineCoinPurseUI$20 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$20(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.oYH.finish();
    }
}

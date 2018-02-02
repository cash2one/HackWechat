package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletOpenFingerprintPayRedirectUI$2 implements OnClickListener {
    final /* synthetic */ WalletOpenFingerprintPayRedirectUI tbi;

    WalletOpenFingerprintPayRedirectUI$2(WalletOpenFingerprintPayRedirectUI walletOpenFingerprintPayRedirectUI) {
        this.tbi = walletOpenFingerprintPayRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tbi.finish();
    }
}

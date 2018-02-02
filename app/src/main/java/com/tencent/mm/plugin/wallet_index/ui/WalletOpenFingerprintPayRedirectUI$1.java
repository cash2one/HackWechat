package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WalletOpenFingerprintPayRedirectUI$1 implements OnCancelListener {
    final /* synthetic */ WalletOpenFingerprintPayRedirectUI tbi;

    WalletOpenFingerprintPayRedirectUI$1(WalletOpenFingerprintPayRedirectUI walletOpenFingerprintPayRedirectUI) {
        this.tbi = walletOpenFingerprintPayRedirectUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WalletOpenFingerprintPayRedirectUI.a(this.tbi);
        WalletOpenFingerprintPayRedirectUI.a(this.tbi, "");
    }
}

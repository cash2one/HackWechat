package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FingerprintWalletLockUI$7 implements OnClickListener {
    final /* synthetic */ FingerprintWalletLockUI tfO;

    FingerprintWalletLockUI$7(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.tfO = fingerprintWalletLockUI;
    }

    public final void onClick(View view) {
        FingerprintWalletLockUI.bNK();
        FingerprintWalletLockUI.a(this.tfO, "user cancel setting fingerprint lock");
    }
}

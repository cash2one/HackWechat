package com.tencent.mm.plugin.walletlock.fingerprint.ui;

class FingerprintWalletLockUI$4 implements Runnable {
    final /* synthetic */ FingerprintWalletLockUI tfO;

    FingerprintWalletLockUI$4(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.tfO = fingerprintWalletLockUI;
    }

    public final void run() {
        FingerprintWalletLockUI.h(this.tfO).setVisibility(0);
    }
}

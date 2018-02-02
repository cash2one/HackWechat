package com.tencent.mm.plugin.walletlock.fingerprint.ui;

class FingerprintWalletLockUI$2 implements Runnable {
    final /* synthetic */ FingerprintWalletLockUI tfO;

    FingerprintWalletLockUI$2(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.tfO = fingerprintWalletLockUI;
    }

    public final void run() {
        this.tfO.finish();
    }
}

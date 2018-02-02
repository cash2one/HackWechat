package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class FingerprintWalletLockUI$12 implements OnCancelListener {
    final /* synthetic */ FingerprintWalletLockUI tfO;

    FingerprintWalletLockUI$12(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.tfO = fingerprintWalletLockUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
        this.tfO.finish();
        FingerprintWalletLockUI.bNK();
    }
}

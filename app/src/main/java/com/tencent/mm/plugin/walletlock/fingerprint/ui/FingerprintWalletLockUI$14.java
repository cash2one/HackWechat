package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.x;

class FingerprintWalletLockUI$14 implements OnClickListener {
    final /* synthetic */ FingerprintWalletLockUI tfO;

    FingerprintWalletLockUI$14(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.tfO = fingerprintWalletLockUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
        ((b) g.h(b.class)).k(this.tfO, 5);
    }
}

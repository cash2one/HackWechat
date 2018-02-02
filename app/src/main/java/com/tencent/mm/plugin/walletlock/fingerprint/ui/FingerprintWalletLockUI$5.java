package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.mm.plugin.walletlock.a$g;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.x;

class FingerprintWalletLockUI$5 implements a {
    final /* synthetic */ FingerprintWalletLockUI tfO;

    FingerprintWalletLockUI$5(FingerprintWalletLockUI fingerprintWalletLockUI) {
        this.tfO = fingerprintWalletLockUI;
    }

    public final void ac(int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            FingerprintWalletLockUI.i(this.tfO);
        } else {
            FingerprintWalletLockUI.b(this.tfO, this.tfO.getString(a$g.teU));
        }
    }
}

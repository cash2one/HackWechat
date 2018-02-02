package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI$a implements b {
    private WeakReference<FingerprintWalletLockUI> mAh = null;
    final /* synthetic */ FingerprintWalletLockUI tfO;

    public FingerprintWalletLockUI$a(FingerprintWalletLockUI fingerprintWalletLockUI, FingerprintWalletLockUI fingerprintWalletLockUI2) {
        this.tfO = fingerprintWalletLockUI;
        this.mAh = new WeakReference(fingerprintWalletLockUI2);
    }

    private FingerprintWalletLockUI bNL() {
        if (this.mAh != null) {
            return (FingerprintWalletLockUI) this.mAh.get();
        }
        return null;
    }

    public final void bNM() {
        FingerprintWalletLockUI.a(this.tfO);
        FingerprintWalletLockUI.b(this.tfO);
    }

    public final void K(int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[]{Integer.valueOf(i), str, Boolean.valueOf(FingerprintWalletLockUI.c(this.tfO))});
        if (!FingerprintWalletLockUI.c(this.tfO)) {
            switch (i) {
                case 0:
                    x.i("MicroMsg.FingerprintWalletLockUI", "identify success");
                    if (bNL() != null) {
                        FingerprintWalletLockUI.d(bNL());
                        return;
                    }
                    return;
                case 1:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
                    if (bNL() != null) {
                        FingerprintWalletLockUI.a(bNL(), i, this.tfO.getString(g.teZ));
                        return;
                    }
                    return;
                case 2:
                    if (bNL() != null) {
                        FingerprintWalletLockUI.b(bNL(), i, this.tfO.getString(g.teX));
                        return;
                    }
                    return;
                case 3:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[]{Integer.valueOf(i)});
                    if (bNL() != null) {
                        FingerprintWalletLockUI.b(bNL(), i, this.tfO.getString(g.teY));
                        return;
                    }
                    return;
                case 4:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
                    return;
                case 5:
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
                    if (bNL() != null) {
                        FingerprintWalletLockUI.a(bNL(), i, this.tfO.getString(g.teZ));
                        return;
                    }
                    return;
                case 8:
                    if (bNL() != null) {
                        FingerprintWalletLockUI.b(bNL(), i, this.tfO.getString(g.tfg));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}

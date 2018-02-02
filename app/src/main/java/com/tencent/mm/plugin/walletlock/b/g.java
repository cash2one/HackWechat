package com.tencent.mm.plugin.walletlock.b;

import com.tencent.d.a.c.i;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public enum g {
    ;
    
    int mType;
    public String thp;
    public i thq;

    private g(String str) {
        this.mType = -1;
    }

    public final void zz(int i) {
        x.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[]{Integer.valueOf(this.mType), Integer.valueOf(i)});
        this.mType = i;
        com.tencent.mm.kernel.g.Dj().CU().a(a.xwB, Integer.valueOf(i));
        com.tencent.mm.kernel.g.Dj().CU().lH(true);
    }

    public final int bOh() {
        if (this.mType == -1) {
            this.mType = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(a.xwB, Integer.valueOf(0))).intValue();
        }
        return this.mType;
    }

    public static boolean bNN() {
        return b.bNN();
    }

    public static void jW(boolean z) {
        x.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.mm.kernel.g.Dj().CU().a(a.xwE, Boolean.valueOf(z));
        com.tencent.mm.kernel.g.Dj().CU().lH(true);
    }

    public static boolean bNC() {
        x.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.bNC())});
        return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bNC();
    }

    public static void jX(boolean z) {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.jU(true);
    }

    public final void jY(boolean z) {
        x.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
        jZ(z);
        jW(false);
    }

    public static void jZ(boolean z) {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.jU(false);
        if (z) {
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.bNB();
        }
    }

    public final boolean bNz() {
        if (this.mType == 1) {
            return b.bNO();
        }
        if (this.mType != 2) {
            return false;
        }
        x.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.bND())});
        return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bND();
    }

    public static void bNE() {
        d.bNE();
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.bNE();
    }

    public static boolean bOi() {
        boolean z;
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("TouchLockFunction", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        return h.bCT() && !z;
    }

    public static boolean bOj() {
        return ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("TouchLockFunction", 0) != 1;
    }
}

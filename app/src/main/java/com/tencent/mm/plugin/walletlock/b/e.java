package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public final class e extends a {
    private static b thi;

    public final void init() {
        x.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[]{bh.i(new Throwable())});
        x.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[]{Integer.valueOf(r0), Integer.valueOf(bh.o(g.Dj().CU().get(40, null), 0) & 8388608)});
        b bVar;
        g gVar;
        if ((bh.o(g.Dj().CU().get(40, null), 0) & 8388608) != 0) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
            bVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            thi = bVar;
            bVar.init();
            gVar = g.tho;
            x.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[]{Boolean.valueOf(h.bCT()), Boolean.valueOf(g.bOi())});
            if (com.tencent.mm.plugin.walletlock.gesture.a.b.bNN() && !r0) {
                x.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[]{Boolean.valueOf(g.Dj().CU().getBoolean(a.xwH, false))});
                if (g.Dj().CU().getBoolean(a.xwH, false)) {
                    bVar = new c();
                    thi = bVar;
                    bVar.init();
                    bOg();
                    return;
                }
            }
        } else if (com.tencent.mm.plugin.walletlock.gesture.a.b.bNN()) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
            bVar = new c();
            thi = bVar;
            bVar.init();
            gVar = g.tho;
            g.jZ(false);
        } else {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
            thi = new a();
            g.tho.jY(false);
            thi.init();
        }
        bOg();
    }

    private static void bOg() {
        x.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[]{Integer.valueOf(g.tho.bOh())});
    }

    public final void a(Activity activity, b.b bVar) {
        if (thi != null) {
            thi.a(activity, bVar);
        }
    }

    public final void a(Activity activity, b.b bVar, b$a com_tencent_mm_plugin_walletlock_a_b_a) {
        if (thi != null) {
            thi.a(activity, bVar, com_tencent_mm_plugin_walletlock_a_b_a);
        }
    }

    public final void j(Activity activity, int i) {
        super.j(activity, i);
    }

    public final void b(Activity activity, int i, int i2) {
        super.b(activity, i, i2);
    }

    public final void L(Activity activity) {
        if (thi != null) {
            thi.L(activity);
        }
    }

    public final void k(Activity activity, int i) {
        Intent intent = new Intent();
        intent.putExtra("action", "action.close_wallet_lock");
        d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
    }

    public final b.b bNx() {
        if (thi != null) {
            return thi.bNx();
        }
        return null;
    }

    public final boolean bNy() {
        g gVar = g.tho;
        if (!g.bNN()) {
            gVar = g.tho;
            if (!g.bNC()) {
                return false;
            }
        }
        return true;
    }

    public final boolean bNz() {
        if (thi != null) {
            return thi.bNz();
        }
        return false;
    }

    public final void c(Activity activity, Intent intent) {
        if (thi != null) {
            thi.c(activity, intent);
        } else {
            super.c(activity, intent);
        }
    }

    public final void b(Activity activity, Intent intent, int i) {
        if (thi != null) {
            thi.b(activity, intent, i);
        } else {
            super.b(activity, intent, i);
        }
    }

    public final void zu(int i) {
        b cVar;
        g gVar;
        if (i == 1) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
            cVar = new c();
            thi = cVar;
            cVar.init();
            gVar = g.tho;
            g.jZ(true);
        } else if (i == 2) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
            cVar = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
            thi = cVar;
            cVar.init();
            gVar = g.tho;
            g.jW(false);
        } else if (i == 0) {
            x.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
            cVar = new a();
            thi = cVar;
            cVar.init();
            g.tho.jY(true);
        } else {
            x.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
        }
    }
}
